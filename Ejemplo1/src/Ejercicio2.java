import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero");
		int n = entrada.nextInt();
		
		
		int contador = 0;
		
		
		do {
			
			contador ++;
			n /= 10;
			
		}while(n > 0);
		
		System.out.println("El número tiene " + contador + " dígitos.");
			
		entrada.close();
		
	}
		

}