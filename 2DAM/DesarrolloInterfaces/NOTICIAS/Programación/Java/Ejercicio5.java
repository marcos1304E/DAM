import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {

		String nombre;
		char n;
		int posicion = 0;

		StringBuilder nombre_final = new StringBuilder();

		Scanner entrada = new Scanner(System.in);

		System.out.println("miau");

		nombre = entrada.nextLine();

		do {
			n = nombre.charAt(posicion);//obtiene el caracter de nombre en la posicion actual
			posicion++;//incrementamos para avanzar al proximo caracter en la siguiente posicion

			nombre_final.append(" ");//añade un espacio en blanco
			nombre_final.append(n);//añade el caracter n obtenido cuando hemos hecho el charAt

		}while(posicion < nombre.length());


		System.out.println("Salida:"+nombre_final);


	}

}
