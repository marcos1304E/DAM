import cv2
import os
from faster_whisper import WhisperModel
from deep_translator import GoogleTranslator
from ultralytics import YOLO
from PIL import Image
from transformers import BlipProcessor, BlipForConditionalGeneration

# 1. CONFIGURACIÓN INICIAL
video_file = "videoAlemanCorto.mp4"

if not os.path.exists(video_file):
    print("¡Archivo no encontrado!")
    exit()

print("Cargando modelos...")
whisper_model = WhisperModel("small", device="cpu", compute_type="int8")
yolo_model = YOLO("yolo11n.pt")
translator = GoogleTranslator(source='auto', target='es')

blip_processor = BlipProcessor.from_pretrained("Salesforce/blip-image-captioning-base")
blip_model = BlipForConditionalGeneration.from_pretrained("Salesforce/blip-image-captioning-base")
print("Modelos listos.\n")

# 2. FASE DE AUDIO (TRANSCRIPCIÓN Y TRADUCCIÓN)
print("\n--- PASO 1: ESCUCHANDO Y TRADUCIENDO ---")
segments, info = whisper_model.transcribe(
     video_file,
     beam_size=10,
     patience=2.0,
     vad_filter=True
)

print(f"Idioma detectado: {info.language.upper()}")

for segment in segments:
    texto_es = translator.translate(segment.text)
    print(f"[{segment.start:.2f}s -> {segment.end:.2f}s] {texto_es}")

print("-" * 30)

# 3. FASE DE VIDEO (ANÁLISIS VISUAL SALTANDO FRAMES)
print("\n--- PASO 2: ANALIZANDO VIDEO (1 FRAME POR SEGUNDO) ---")
cap = cv2.VideoCapture(video_file)
fps = cap.get(cv2.CAP_PROP_FPS)
total_frames = int(cap.get(cv2.CAP_PROP_FRAME_COUNT))
duracion_segundos = total_frames / fps

def formato_tiempo(segundos):
    m = int(segundos // 60)
    s = int(segundos % 60)
    return f"{m:02d}:{s:02d}"

def describir_frame(frame):
    imagen = Image.fromarray(cv2.cvtColor(frame, cv2.COLOR_BGR2RGB))
    inputs = blip_processor(imagen, return_tensors="pt")
    output = blip_model.generate(**inputs, max_new_tokens=40)
    descripcion_en = blip_processor.decode(output[0], skip_special_tokens=True)
    return translator.translate(descripcion_en)

CONFIANZA_MIN = 0.6
SEGUNDOS_MIN   = 3
IGNORAR_SI_HAY_PERSONA = {"dog", "cat", "horse", "sheep", "cow", "bear"}

objetos_activos = {}
objetos_confirmados = {}
segundo_actual = 0

while segundo_actual < duracion_segundos:
    frame_id = int(segundo_actual * fps)
    cap.set(cv2.CAP_PROP_POS_FRAMES, frame_id)
    ret, frame = cap.read()

    if not ret:
        break

    results = yolo_model(frame, conf=CONFIANZA_MIN, verbose=False)

    objetos_en_frame = set()
    for result in results:
        clases = result.boxes.cls.int().tolist()
        for c in clases:
            objetos_en_frame.add(yolo_model.names[c])

    if "person" in objetos_en_frame:
        objetos_en_frame -= IGNORAR_SI_HAY_PERSONA

    for nombre in objetos_en_frame:
        if nombre not in objetos_activos:
            objetos_activos[nombre] = {"inicio": segundo_actual, "consecutivos": 1, "frame": frame.copy()}
        else:
            objetos_activos[nombre]["consecutivos"] += 1

        if objetos_activos[nombre]["consecutivos"] >= SEGUNDOS_MIN and nombre not in objetos_confirmados:
            descripcion = describir_frame(objetos_activos[nombre]["frame"])
            objetos_confirmados[nombre] = {
                "inicio": objetos_activos[nombre]["inicio"],
                "descripcion": descripcion
            }

    desaparecidos = [n for n in list(objetos_activos) if n not in objetos_en_frame]
    for nombre in desaparecidos:
        if nombre in objetos_confirmados:
            datos = objetos_confirmados.pop(nombre)
            inicio = datos["inicio"]
            descripcion = datos["descripcion"]
            fin = segundo_actual - 1
            print(f"[{formato_tiempo(inicio)} --> {formato_tiempo(fin)}] {descripcion}")
        objetos_activos.pop(nombre)

    segundo_actual += 1

for nombre, datos in objetos_confirmados.items():
    fin = segundo_actual - 1
    print(f"[{formato_tiempo(datos['inicio'])} --> {formato_tiempo(fin)}] {datos['descripcion']}")

cap.release()
print("\n--- PROCESO FINALIZADO ---")
