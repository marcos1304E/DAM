package javanio;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class Main {

	
	//Lectura con la clase Files de java.NIO
	public static void  LeerFiles() {
		
		Path ruta = Paths.get("planetas.txt");
		try {
			//Leo todo el documento del fichero
			String contenido = Files.readString(ruta);
			System.out.println(contenido);
			System.out.println("-----------------------------");
			
			//Leer linea por linea de un fichero
			List<String> listaContenido = Files.readAllLines(ruta);
			for(String linea:listaContenido) {
				System.out.println("linea: "+linea);
			}
			
			
		}catch(IOException e) {
			e.getMessage();
		}
	}
	
	
	public static void EscrituraFiles() {
		Path ruta = Paths.get("FicheroEscritura.txt");
		try {
			String contenido = "Hola esya es mi primera escritura";
			Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.CREATE);
		} catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void Copiar() {
		Path rutaOrigen = Paths.get("FicheroEscritura.txt");
		Path rutaDestino = Paths.get("FicheroCopia.txt");
		
		try {
			Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	//Listar los contenidos de un directorio
	public static void listarContenidos() {
		//Path.of = Path.get
		Path directorio = Path.of(".");
		try {
			Stream <Path> flujo = Files.list(directorio);
			flujo.forEach(archivo -> System.out.println(archivo.getFileName()));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Lee las propiedades de un archivo
	public static void PropiedadesFichero() {
		Path ruta = Path.of("primos.txt");
		System.out.println("Fichero existe: "+Files.exists(ruta));
		System.out.println("Fichero es directorio: "+Files.isDirectory(ruta));
	}
	
	//Borra un archivo
	public static void BorrarFichero() {
		
		Path ruta = Path.of("primos.txt");
		try {
			Files.deleteIfExists(ruta);
		} catch(IOException e) {
			e.getMessage();
		}
		
	}
	
	
	public static void main(String[] args) {
		LeerFiles();
		EscrituraFiles();
		Copiar();
		listarContenidos();
		PropiedadesFichero();
		BorrarFichero();
			
		
	}

}
