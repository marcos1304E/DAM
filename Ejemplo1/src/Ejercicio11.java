import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {

Scanner entrada = new Scanner(System.in);
		
		System.out.println("altura?");
		int altura = entrada.nextInt();
		
		
		System.out.println("triangulo macizo:");
		
		for(int i = 0; i <= altura; i++) {
			
			for(int j = 0; j < altura - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		entrada.close();
		
	}

}