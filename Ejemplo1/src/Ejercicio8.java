import java.util.Scanner;

public class Ejercicio8 {
		
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("palabra");
		
		String palabra = entrada.next();
		
		int len = palabra.length();
		
		
		if(Buscar_letras(palabra, 0, len -1)) {
			System.out.println("palindromo");
		} else {
			System.out.println("no es palindromo");
		}
		
		entrada.close();
		
	}	
		
		private static boolean Buscar_letras(String str, int ini, int fin) {
			if(ini >= fin) {
				return true;
			}
			if(str.charAt(ini) != str.charAt(fin)) {
				return false;
			}
			return Buscar_letras(str, ini+1, fin -1);
			/*
			 * for(int i = 0; i < longitud / 2; i++){
			 * 		
			 * 		if(palabra.charAt(i) != palabra.charAt(longitud -i -1)){
			 * 
			 * 			return false;			
			 * 
			 * 		}
			 * 	return true;//brrr
			 * }
			 * 
			 */ 
			
	}
	
}