package simulacro;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	private String nombre;
	private  static ArrayList <Articulos> articulos;
	private static ArrayList<Libros> listaLibros;
    private static ArrayList<Revistas> listaRevistas;
	private static ArrayList <Prestamo> prestamos ;
	private static int contadorId = 1;
	private static ArrayList<Usuario> usuarios;

	
	
	public Biblioteca(String nombre) {
        this.nombre        = nombre;
        this.articulos     = new ArrayList<>();
        this.listaLibros   = new ArrayList<>();
        this.listaRevistas = new ArrayList<>();
        this.prestamos     = new ArrayList<>();
        this.usuarios	   = new ArrayList<>();
    }
	
	
	public static void agregarArticulo() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Libro o revista (1/2)");
		int opcion = entrada.nextInt();
		entrada.nextLine();
		
		//int nuevoId = articulos.size() + 1;
		int nuevoId = contadorId++;
		
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
			
			System.out.println("El libro se añadió correctamente.");
			
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

			System.out.println("La revista se añadió correctamente.");
			
			System.out.println("ID: "+ nuevoId);
			System.out.println("Titulo: "+ nuevoTitulo);
			System.out.println("Numero de edicion: "+ nuevoNumEdicion);
			
			
		} else {
			System.out.println("Opción no valida.");
		}
			
		
	}
	
		
		public static void buscarArticuloPorId() {
		    Scanner entrada = new Scanner(System.in);

		    System.out.println("¿Qué libro quieres encontrar? Escribe su ID:");
		    int idABuscar = entrada.nextInt();
		    entrada.nextLine();

		    for (Articulos articulo : articulos) {
		    	
		        if (articulo.getId_unico() == idABuscar) {
		        	
		            System.out.println("Artículo encontrado:");
		            System.out.println("ID: " + articulo.getId_unico());
		            System.out.println("Titulo: " + articulo.getTitulo());
		            System.out.println("Estado: " + (articulo.isEstadoDisponibilidad() ? "Disponible" : "No disponible"));
		            return;
		        }
		    }

		}
		
		
		
	public static void mostrarTodos() {
		
		    if (articulos.isEmpty()) {
		    	
		        System.out.println("No hay artículos almacenados.");
		        
		    } else {
		    	
		        System.out.println("Lista de artículos:");
		        for (Articulos articulo : articulos) {
		        	
		            System.out.println(articulo);
		        }
		    }
		}
		
		
	public static void prestarArticulo(int idAPrestar) {
	
		
		Scanner entrada = new Scanner(System.in);
	
		System.out.println("Introduce el ID del usuario");
		int idUsuario = entrada.nextInt();
		
		
		System.out.println("Que libro quieres que te preste (ID)");
		idAPrestar = entrada.nextInt();
		
		Usuario usuarioEncontrado = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getIdUsuario() == idUsuario) {
				usuarioEncontrado = usuario;				
				break;
			}
		}
	
		for (Articulos articulo : articulos) {
			if (articulo.getId_unico() == idAPrestar) {
				if (articulo.isEstadoDisponibilidad()) {
					
					articulo.setEstadoDisponibilidad(false);
					
					Prestamo prestamo = new Prestamo ("22/05/2025", articulo, usuarioEncontrado );
					prestamos.add(prestamo);
					System.out.println("se prestóóóóó");
				}
			}
		
		}
						
	}
	
	
	public static void devolverArticulo() {
		
		 Scanner entrada = new Scanner(System.in);

		    System.out.println("Introduce el ID del artículo que quieres devolver:");
		    int idADevolver = entrada.nextInt();

		    for (Articulos articulo : articulos) {
		    	
		    	if(articulo.getId_unico() == idADevolver) {
		    		
		    		if (!articulo.isEstadoDisponibilidad()) {
		    			
		                articulo.setEstadoDisponibilidad(true);

		    		}
		    	}
		    }
		
	}
	
	
	public static void agregarUsuario(Usuario usuario) {
		
	    usuarios.add(usuario);
	    
	}
	
	
}
