import java.util.Scanner;

public class LeerPorTeclado {
	public static void main(String[] args) {
		String nombre, apellido;
		int edad;
		
		int n;
		System.out.println("Cuantos alumnos quieres añadir?");
		Scanner entrada = new Scanner(System.in);
		n = entrada.nextInt();
		entrada.nextLine();
		for(int i = 0; i < n; i++) {
		System.out.println("Introduzca su nombre");
		
		//entrada es una instancia de la clase scanner
		
		
		nombre = entrada.nextLine();//LEER LINEA
		System.out.println("Hola, "+nombre);
		
		System.out.println("Introduzca su edad");
		edad = entrada.nextInt();//LEE EL ENTERO
		System.out.println("edad: "+edad);
	
		entrada.nextLine();//PARA LIMPIAR EL BUFFER
		
		System.out.println("Introduzca su apellido");
		apellido = entrada.nextLine();//nos vuelve a pedir, la edad y la imprimimos//LEE LINEA
		System.out.println("apellido: "+apellido);
		
		entrada.close();
		}
	}
	
}
