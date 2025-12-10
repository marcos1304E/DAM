import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int n, suma = 0;//para acumular suma de los nums ingresados
		String expresion = "";//almacena representacion en forma de suma (2+3+4) como una cadena de texto, que inicialmente está vacia.
				


		System.out.println("Introduce números enteros");

		while (true) {
			n = entrada.nextInt();
			if (n <= 0) {
				break;
			}
			suma += n;//acumulamos numero en variable

			if (!expresion.isEmpty()) {//si la expresion no está vacía, se agrega un '+' antes del siguiente numero, para representar la suma

				expresion += "+";
			}//luego se concatena
			expresion += n;
		}

		if (!expresion.isEmpty()) {
			System.out.println(expresion + "=" + suma);
		} else {
			System.out.println("No se introdujeron números válidos.");
		}

		entrada.close();
	}

}
