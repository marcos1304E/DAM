package datos;

import modelo.Noticia;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GestionNoticias {

	public Noticia descargarTitular(String nombreFuente, String categoria) {

		String url = obtenerUrl(nombreFuente);
		String titular = "No se pudo cargar el titular";

		try {
			if (!url.isEmpty()) {

				// Truco: Simulamos ser un navegador real para evitar bloqueos
				Document doc = Jsoup.connect(url).userAgent(
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
						.timeout(5000).get();

				Element elementoTitulo = null;

				// --- ZONA DE EXCEPCIONES (Webs que no funcionan con H1/H2 normal) ---
				if (nombreFuente.equals("Fotogramas")) {
					// Fotogramas tiene el título dentro de un div específico
					elementoTitulo = doc.select("div.cal-result-list h2 a").first();
				}  else if (nombreFuente.equals("Sensacine")) {
					elementoTitulo = doc.select("a.meta-title-link").first();
				}else if (nombreFuente.equals("The Guardian")) {
                    try {
                        // The Guardian usa 'data-link-name="splash"' para la noticia principal
                        // y el titular suele estar dentro
                        elementoTitulo = doc.select("div[data-link-name='splash'] a").first();
                        
                        // Si falla, probamos con el primer h3 (allí usan h3 para titulares)
                        if (elementoTitulo == null) {
                            elementoTitulo = doc.select("h3").first();
                        }
                    } catch (Exception e) {
                        elementoTitulo = null;
                    }
                }

				// --- LÓGICA GENÉRICA (Tu código original) ---
				// Si no es ninguna de las "especiales", usamos tu sistema H1/H2
				if (elementoTitulo == null) {
					elementoTitulo = doc.select("h1").first();

					if (elementoTitulo == null) {
						elementoTitulo = doc.select("h2").first();
					} else if (elementoTitulo.text().length() < 15) {
						// He subido a 15 caracteres para evitar palabras como "Menú" o "Suscríbete"
						elementoTitulo = doc.select("h2").first();
					}
				}

				// Si encontramos algo, guardamos el texto
				if (elementoTitulo != null) {
					titular = elementoTitulo.text();
				}
			}
		} catch (IOException e) {
			System.out.println("Error al conectar con " + nombreFuente + ": " + e.getMessage());
			titular = "Error de conexión con la fuente";
		}

		return new Noticia(titular, nombreFuente, categoria);
	}

	private String obtenerUrl(String fuente) {
		switch (fuente) {
		// --- ECONOMÍA ---
		case "El Economista":
			return "https://www.eleconomista.es/";
		case "Expansión":
			return "https://www.expansion.com/";
		case "Cinco Días":
			return "https://cincodias.elpais.com/";

		// --- DEPORTES ---
		case "Marca":
			return "https://www.marca.com/";
		case "As":
			return "https://as.com/";
		case "Mundo Deportivo":
			return "https://www.mundodeportivo.com/";

		// --- NACIONAL ---
		case "El País":
			return "https://elpais.com/";
		case "El Mundo":
			return "https://www.elmundo.es/";
		case "ABC":
			return "https://www.abc.es/";

		// --- INTERNACIONAL ---
		case "The Guardian":
			return "https://www.theguardian.com/international";
		case "BBC News":
			return "https://www.bbc.com/news";
		case "Le Monde":
			return "https://www.lemonde.fr/";

		case "3DJuegos":
			return "https://www.3djuegos.com/";
		case "Vandal":
			return "https://vandal.elespanol.com/";
		case "Meristation":
			return "https://as.com/meristation/";

		case "Fotogramas":
			return "https://www.fotogramas.es/";
		case "Espinof":
			return "https://www.espinof.com/";
		case "Sensacine":
			return "https://www.sensacine.com/";

		default:
			return "";
		}
	}
}