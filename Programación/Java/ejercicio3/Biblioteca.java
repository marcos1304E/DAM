import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	private String nombre;
	private static ArrayList <Articulos> articulos;
	private static ArrayList<Libros> listaLibros;
    private static ArrayList<Revistas> listaRevistas;
	private static ArrayList <Prestamo> prestamos ;
	
	
	
	public Biblioteca(String nombre) {
        this.nombre        = nombre;
        this.articulos     = new ArrayList<>();
        this.listaLibros   = new ArrayList<>();
        this.listaRevistas = new ArrayList<>();
        this.prestamos     = new ArrayList<>();
    }
	
	
	
	public static void agregarArticulo() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Libro o revista (1/2)");
		int opcion = entrada.nextInt();
		entrada.nextLine();
		
		int nuevoId = articulos.size() + 1;
		
		System.out.println("Titulo: ");
		String nuevoTitulo = entrada.nextLine();
		
		boolean nuevoEstado = true;
		

		if (opcion == 1) {
			
			System.out.println("Autor: ");
			String nuevoAutor = entrada.nextLine();
			
			Libros libro = new Libros(nuevoId, nuevoTitulo, nuevoEstado, nuevoAutor);
			Articulos articulo = new Articulos(nuevoId, nuevoTitulo, nuevoEstado);
			
			listaLibros.add(libro);
			articulos.add(articulo);
			
			System.out.println("El libro se agregó correctamente.");
			
			System.out.println("ID: "+ nuevoId);
			System.out.println("Titulo: "+ nuevoTitulo);
			System.out.println("Autor: "+ nuevoAutor);
			
			
			
		} else if (opcion == 2) {
			
			System.out.println("¿Cuál es el número de edición?");
			int nuevoNumEdicion = entrada.nextInt();
			
			Revistas revista = new Revistas(nuevoId, nuevoTitulo, nuevoEstado, nuevoNumEdicion);
			Articulos articulo = new Articulos(nuevoId, nuevoTitulo, nuevoEstado);
			
			listaRevistas.add(revista);
			articulos.add(articulo);

			System.out.println("La revista se agregó correctamente.");
			
			System.out.println("ID: "+ nuevoId);
			System.out.println("Titulo: "+ nuevoTitulo);
			System.out.println("Numero de edicion: "+ nuevoNumEdicion);
			
			
		} else {
			System.out.println("Opción no valida.");
		}
		
		
		
	}

	//buscarArticuloPorId(id)
	
	//mostrarTodos();
	
}
