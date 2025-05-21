package biblio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Biblioteca MiBiblioteca = new Biblioteca("Mi Biblioteca");
		
		menu();
	}
		public static void menu() {
			Scanner entrada = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("\n MENÚ PRINCIPAL");
	            System.out.println("1. Agregar Articulo");
	            System.out.println("2. ");
	            System.out.println("3. ");
	            System.out.println("4. ");
	            System.out.println("5. Salir");
	            System.out.print("Selecciona una opción: ");

	            opcion = entrada.nextInt();
	            entrada.nextLine();

	            switch (opcion) {
	                case 1:
	                    Biblioteca.agregarArticulo();
	                    break;
	                case 2:
	                    
	                    break;
	                case 3:
	                    
	                    break;
	                case 4:
	                    
	                    break;
	                case 5:
	                	
	                	break;
	                default:
	                    System.out.println("Opción no válida.");
	            }

	        } while (opcion != 5);

	        entrada.close();
		}
		
		
	

}
