import java.util.Scanner;

	public class Menu {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("====== MENÚ PRINCIPAL ======");
	            System.out.println("1. Ver información");
	            System.out.println("2. Agregar datos");
	            System.out.println("3. Eliminar datos");
	            System.out.println("4. Salir");
	            System.out.print("Selecciona una opción: ");
	            
	            opcion = scanner.nextInt();
	            
	            switch (opcion) {
	                case 1:
	                    System.out.println("Has seleccionado 'Ver información'.");
	                    // Aquí puedes llamar a un método que muestre información
	                    break;
	                case 2:
	                    System.out.println("Has seleccionado 'Agregar datos'.");
	                    // Aquí puedes implementar lógica para agregar datos
	                    break;
	                case 3:
	                    System.out.println("Has seleccionado 'Eliminar datos'.");
	                    // Aquí puedes implementar lógica para eliminar datos
	                    break;
	                case 4:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción no válida. Intenta de nuevo.");
	            }

	            System.out.println(); // Línea en blanco
	            
	        } while (opcion != 4);

	        scanner.close();
	    }
	}

	
