package datos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import modelo.Noticia;

public class GestionNoticias {

	public Noticia descargarTitular(String nombreFuente, String categoria) {
		String url = obtenerUrl(nombreFuente);

		String titular = "No se ha podido descargar el contenido. Conéctese a Internet.";

		if (url == null) {
			return new Noticia(titular, nombreFuente, categoria);
		}

		try {
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(5000).get();

			Elements candidatos = null;

			if (nombreFuente.equals("The Guardian")) {
				candidatos = doc.select("h3 .js-headline-text, h3 a");
			} else if (nombreFuente.equals("IGN España")) {
				candidatos = doc.select("h3 a");
			} else if (nombreFuente.equals("Meristation")) {
				candidatos = doc.select("h2 a");
			} else if (nombreFuente.equals("El País") || nombreFuente.equals("Cinco Días")) {
				candidatos = doc.select("h2 a");
			} else {
				candidatos = doc.select("h2 a, h3 a, .ue-c-cover-content__headline");
			}

			if (candidatos != null && !candidatos.isEmpty()) {
				for (Element e : candidatos) {
					if (!esTituloInvalido(e)) {
						titular = e.text();
						break;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Fallo de conexión en " + nombreFuente);
		}

		return new Noticia(titular, nombreFuente, categoria);
	}

	private boolean esTituloInvalido(Element e) {
		if (e == null)
			return true;
		String texto = e.text().trim().toUpperCase();

		if (texto.length() < 10)
			return true;
		if (texto.contains("DESTACADAS"))
			return true;
		if (texto.contains("LO MÁS LEÍDO"))
			return true;
		if (texto.contains("SUSCRÍBETE"))
			return true;
		if (texto.contains("INICIAR SESIÓN"))
			return true;
		if (texto.contains("NEWSLETTERS"))
			return true;
		if (texto.contains("COOKIES"))
			return true;
		if (texto.equals("NEWS"))
			return true;
		if (texto.equals("OPINIÓN"))
			return true;

		return false;
	}

	private String obtenerUrl(String nombreFuente) {
		switch (nombreFuente) {
		case "El Economista":
			return "https://www.eleconomista.es/";
		case "Expansión":
			return "https://www.expansion.com/";
		case "Cinco Días":
			return "https://cincodias.elpais.com/";
		case "Marca":
			return "https://www.marca.com/";
		case "As":
			return "https://as.com/";
		case "Mundo Deportivo":
			return "https://www.mundodeportivo.com/";
		case "El País":
			return "https://elpais.com/";
		case "El Mundo":
			return "https://www.elmundo.es/";
		case "ABC":
			return "https://www.abc.es/";
		case "The Guardian":
			return "https://www.theguardian.com/international";
		case "BBC News":
			return "https://www.bbc.com/news";
		case "Le Monde":
			return "https://www.lemonde.fr/";
		case "3DJuegos":
			return "https://www.3djuegos.com/";
		case "IGN España":
			return "https://es.ign.com/";
		case "Meristation":
			return "https://as.com/meristation/";
		case "Fotogramas":
			return "https://www.fotogramas.es/";
		case "Espinof":
			return "https://www.espinof.com/";
		case "Sensacine":
			return "https://www.sensacine.com/";
		default:
			return null;
		}
	}
}