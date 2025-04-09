import java.util.Scanner;

public class LeerPorTeclado {
	
	public static void main(String[] args) {		
		
		Scanner entrada = new Scanner(System.in);//entrada es una instancia de la clase scanner

/*
		String nombre, apellido;
		int edad;
*/		
		
		System.out.println("Cuantos alumnos quieres añadir?");
		int n = entrada.nextInt();
		entrada.nextLine();
		
		String nombres[] = new String[n];
		int edades[] = new int[n];
		String apellidos[] = new String[n];
	
		
		for(int i = 0; i < n; i++) {
			
		
		System.out.println("Introduzca su nombre");
		nombres[i] = entrada.nextLine();//LEER LINEA
		System.out.println("Hola, "+nombres[i]);
		
		System.out.println("Introduzca su edad");
		edades[i] = entrada.nextInt();//LEE EL ENTERO
		System.out.println("edad: "+edades[i]);
	
		entrada.nextLine();//PARA LIMPIAR EL BUFFER
		
		System.out.println("Introduzca su apellido");
		apellidos[i] = entrada.nextLine();//nos vuelve a pedir, la edad y la imprimimos//LEE LINEA
		System.out.println("apellido: "+apellidos[i]);
		
		}
		entrada.close();

		for(int i = 0; i < n; i++) {
			System.out.println("Alumno: "+nombres[i]+", Edad:"+edades[i]+", Apellido:"+apellidos[i]);
		}
	}
	
}