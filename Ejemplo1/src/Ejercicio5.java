import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
				
		Scanner entrada = new Scanner(System.in);

		System.out.println("introduce una palabra");
		
		String nombre = entrada.nextLine();
		
	for(int i = 0; i < nombre.length(); i++) {
		System.out.print(nombre.charAt(i)+" ");
	
		}
		
	entrada.close();

	}
	
}

/*
 * 
 * 
 * do {
			n = nombre.charAt(posicion);//obtiene el caracter de nombre en la posicion actual
			posicion++;//incrementamos para avanzar al proximo caracter en la siguiente posicion
			
			nombre_final.append(" ");//añade un espacio en blanco
			nombre_final.append(n);//añade el caracter n obtenido cuando hemos hecho el charAt

		}while(posicion < nombre.length());
 * */