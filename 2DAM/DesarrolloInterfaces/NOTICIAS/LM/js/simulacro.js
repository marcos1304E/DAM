let abecedario = "abcdefghijklmnopqrstuvwxyz";
let letraAdivinar;
let coordenada1;
let coordenada2;

function traduccion(letra){
    let numero = 0;
    let esta = false;
    while (!esta) {
        if(abecedario[numero] === letra){
            esta = true;

        } else {
            if (abecedario.length === 27){
                numero =- 1;
                esta = true;
            } else {
                numero++;
            }
        }
    }
    return numero + 1;
    
}

/*
regular
escribir en html con div
eventos reflejados en tablero
tabla
*/

function codificarTexto(){
    let salida = document.getElementById("textoCodificado");
    let letra = event.key;

    salida.textContent += traduccion(letra) + " ";
}

function random(numero){
    return Math.floor(Math.random() * numero+1);
}

function generarDatos(){
    letra = abecedario[random(27)];
    coordenada1 = random(1);
    coordenada2 = random(1);
    document.getElementById("letra").textContent = letra;
    document.getElementById("i").textContent = coordenada1;
    document.getElementById("i").textContent = coordenada2;
}

function colocarCasillas(event){
    let i = event.target.name[0];
    let j = event.target.name[1];
    let letra = event.target.value;

    console.log(i+","+j+"->"+letra);
    
    if (i == coordenada1 && j == coordenada2 && letraAdivinar == letra){
        document.getElementById(event.target.name).textContent = letra;
    }
}

function load(){
    let texto = document.getElementById("textoACodificado");

    texto.addEventListener("keydown", codificarTexto);

    //ej2
    intervalo  = setInterval(generarDatos, 3000);
    let letras = document.querySelectorAll(".letra");
    letras.forEach(i =>i.addEventListener("keydown", colocarCasillas))
}

window.addEventListener("DOMContentLoaded", load);