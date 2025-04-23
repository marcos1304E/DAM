import java.util.Scanner;

	public class Menu {
	    public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);
	        int opcion;
	        

	        do {
	            System.out.println("====== MENÚ PRINCIPAL ======");
	            System.out.println("1. Rectángulo");
	            System.out.println("2. Triangulo rectangulo");
	            System.out.println("3. Triangulo equilatero");
	            System.out.println("4. Salir");
	            System.out.print("Selecciona una opción: ");
	            
	            opcion = entrada.nextInt();
	            
	            switch (opcion) {
	                case 1:
	                    System.out.println("Rectangulo");
	                    System.out.println("con relleno o sin relleno (1/2)");
	                    int tipo = entrada.nextInt();
	                    		if(tipo == 1) {
	                    			System.out.println("base?");
	                    			int base = entrada.nextInt();
	                    			System.out.println("altura?");
	                    			int altura = entrada.nextInt();
	                    			
	                    			System.out.println("macizo:");
	                    			
	                    			for(int i = 0; i < altura; i++) {
	                    				for(int j = 0; j < base; j++) {
	                    					System.out.print("*");
	                    				}
	                    				
	                    				System.out.println();
	                    				
	                    			}
	                    		} else {
	                    			System.out.println("base?");
	                    			int base = entrada.nextInt();
	                    			System.out.println("altura?");
	                    			int altura = entrada.nextInt();
	                    			for(int i = 0; i < base; i++) {
	                    				System.out.print("*");
	                    			}
	                    			
	                    			System.out.println();
	                    			
	                    			for(int i = 0; i < altura; i++) {
	                    				System.out.print("*");
	                    				for(int j = 0; j < base-2; j++) {
	                    					System.out.print(" ");
	                    				}
	                    				System.out.println("*");
	                    			}
	                    			
	                    			for(int i = 0; i < base; i++) {
	                    				System.out.print("*");
	                    			}
	                    		}
	                    break;
	                    
	                case 2:
	                    System.out.println("Triangulo rectangulo");
	                    System.out.println("con relleno o sin relleno (1/2)");
	                    
	                    int tipo = entrada.nextInt();
                		if(tipo == 1) {
	                    break;
	                case 3:
	                    System.out.println("Triangulo equilatero");
	                    System.out.println("con relleno o sin relleno (1/2)");
	                    
	                    break;
	                case 4:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción no válida. Intenta de nuevo.");
	            }

	            System.out.println();
	            
	        } while (opcion != 4);

	        entrada.close();
	    }
	}

	
