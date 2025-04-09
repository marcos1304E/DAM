import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		String valor = "";
		
		String [] palabras = new String [5];
		
		for(int i = 0; i< 5; i++) {
			System.out.println("palabra");
			palabras[i]=entrada.next();
			
			if(palabras[i].length() > valor.length()) {
				valor = palabras[i];
			}
			
		}
		System.out.println("palabra más larga: "+valor);
	}

}