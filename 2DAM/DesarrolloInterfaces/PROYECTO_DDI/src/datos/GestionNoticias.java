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
                
                Document doc = Jsoup.connect(url).userAgent("Mozilla").timeout(5000).get();

                
                Element elementoTitulo = doc.select("h1").first();
                
                if (elementoTitulo == null) {
                    elementoTitulo = doc.select("h2").first();
                } else if (elementoTitulo.text().length() < 10) { 
                    // Si el H1 es muy corto (tipo "Menu"), buscamos el siguiente
                     elementoTitulo = doc.select("h2").first();
                }

                if (elementoTitulo != null) {
                    titular = elementoTitulo.text();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al conectar con " + nombreFuente);
            titular = "Error de conexión con la fuente";
        }

        return new Noticia(titular, nombreFuente, categoria);
    }

    
    private String obtenerUrl(String fuente) {
        switch (fuente) {
            // ECONOMIA
            case "El Economista": return "https://www.eleconomista.es/";
            case "Expansión": return "https://www.expansion.com/";
            case "Cinco Días": return "https://cincodias.elpais.com/";
            
            // DEPORTES
            case "Marca": return "https://www.marca.com/";
            case "As": return "https://as.com/";
            case "Mundo Deportivo": return "https://www.mundodeportivo.com/";
            
            // NACIONAL
            case "El País": return "https://elpais.com/";
            case "El Mundo": return "https://www.elmundo.es/";
            case "ABC": return "https://www.abc.es/";
            
            // INTERNACIONAL
            case "CNN": return "https://edition.cnn.com/";
            case "BBC News": return "https://www.bbc.com/news";
            case "Le Monde": return "https://www.lemonde.fr/";
            
            // LIBRES
            case "3DJuegos": return "https://www.3djuegos.com/";
            case "Fotogramas": return "https://www.fotogramas.es/";
            
            default: return "";
        }
    }
}