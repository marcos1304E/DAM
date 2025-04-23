import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("altura?");
		int altura = entrada.nextInt();
		
		
		System.out.println("triangulo macizo:");
		
		for(int i = 0; i < altura; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
		}
				
		System.out.println("triangulo solo bordes:");
		
		
		System.out.println("*");
		
		//Este for imprime las líneas intermedias con un asterisco al inicio, luego espacios, y otro asterisco al final,
		for(int i = 0; i < altura-2; i++) {		//Se repite altura - 2 veces porque ya imprimimos la primera línea y reservamos la última para la base.
			System.out.print("*");
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		
		for(int i = 0; i < altura; i++) {
			System.out.print("*");
			
		}
		
		
		entrada.close();
		
		
	}
	
}