import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Ingresa una cadena de texto: ");
        String texto = entrada.nextLine();
        
        int cantidadPalabras=contarPalabras(texto.trim());
        
        System.out.println("Texto tiene " +(cantidadPalabras+1)+" palabras");
        entrada.close();
	
	}
	
	private static int contarPalabras(String texto) {
		//int cantidad = 0;
		
		int contador = 0;
		
		if(texto.length()== 0) return 0;
		
		//if(character.isLetter(texto.charAt(0))) contador++;
		 
		 
		 
		for(int i = 0; i < texto.length(); i++) {
			
			if(texto.charAt(i) == ' ' && Character.isLetter(texto.charAt(i+1))) { 	//texto.charAt(i+1) != ' '
				
				contador++;	//cantidad++;
				
			}
			
		}
		return contador;
		
	}

}


/*
 * 
 * texto = texto.trim(); // Elimina espacios al inicio y final
        
        int longitud = texto.length();
        int contador = 0;
        boolean dentroDePalabra = false;
        
 *for (int i = 0; i < longitud; i++) {
            if (texto.charAt(i) != ' ') {
                if (!dentroDePalabra) {
                    contador++;
                    dentroDePalabra = true;
                }
            } else {
                dentroDePalabra = false;
            }
        }

        System.out.println("Cantidad de palabras: " + contador);
 * 
 * */
 