import java.util.Scanner;

public class PalabraMayor {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		String palabraMayor = "";

		System.out.println("Introduce 5 palabras:");

		for (int i = 0; i < 5; i++) {
			String palabra = entrada.nextLine();

			
			if (palabra.length() > palabraMayor.length()) {
				palabraMayor = palabra;
			}//PalabraMayor está vacia, si la que ingresamos es mayor, la actualizamos, y vamos comparando con las palabras restantes
		}

					
		System.out.println("La palabra con mayor longitud es: " + palabraMayor);

		entrada.close();
	}
}

