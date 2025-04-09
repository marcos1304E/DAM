import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		int numeros=0, resultado=0, digitos=0, total=0, temp=0;
		
		String frase = "";
		
		Scanner entrada = new Scanner(System.in);
		
		numeros= entrada.nextInt();
		
		while(numeros>0) {
			digitos=0;
			resultado=0;
			temp= numeros;
			
			while(temp > 0) {
			resultado += temp%10 ;
			digitos+=1;
			temp/=10;	
			}	
		
		if(resultado == digitos) {
			frase+=numeros+"+";
			total+=numeros;
		}
		
		System.out.println("Introduce un numero >= 0");
		numeros= entrada.nextInt();
		
		}
		frase+=numeros+"+";
		System.out.println("el resultado es "+frase+total);
		entrada.close();
		
		
	}

}