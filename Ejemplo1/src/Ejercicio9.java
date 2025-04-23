import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
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
		
		System.out.println("solo bordes:");
		
	/*	for(int i = 0; i < altura; i++) {
			for(int j = 0; i < base; j++) {
				if(i > 0 && i < altura-1) {
					if(j>0 && j < base-1) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	*/	
		//leonard
		
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
		
		entrada.close();
		
	}

}