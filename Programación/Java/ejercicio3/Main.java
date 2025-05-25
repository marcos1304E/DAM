package simulacro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//ArrayList <Usuario> usuarios = null;
		
		Biblioteca MiBiblioteca = new Biblioteca("Mi Biblioteca");
		
		Usuario usuario1 = new Usuario(1, "Pepito");
		//usuarios.add(usuario);
		Biblioteca.agregarUsuario(usuario1);
		Usuario usuario2 = new Usuario(2, "Jaimito");
        Biblioteca.agregarUsuario(usuario2);

		
		//usuarios.add(usuario);

		menu();
		
	}
		public static void menu() {
			Scanner entrada = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("\n MENÚ PRINCIPAL");
	            System.out.println("1. Agregar Articulo");
	            System.out.println("2. Mostrar todos los articulos");
	            System.out.println("3. Buscar Articulo Por ID");
	            System.out.println("4. Prestar un articulo");
	            System.out.println("5. Salir");
	            System.out.print("Selecciona una opción: ");

	            opcion = entrada.nextInt();
	            entrada.nextLine();

	            switch (opcion) {
	                case 1:
	                    Biblioteca.agregarArticulo();
	                    break;
	                case 2:
	                    Biblioteca.mostrarTodos();
	                    break;
	                case 3:
	                    Biblioteca.buscarArticuloPorId();
	                    break;
	                case 4:
	                    Biblioteca.prestarArticulo(opcion);
	                    break;
	                case 5:
	                	System.out.println("Saliendo");
	                	break;
	                default:
	                    System.out.println("Opción no válida.");
	            }

	        } while (opcion != 5);

	        entrada.close();
		}
		
	

}
