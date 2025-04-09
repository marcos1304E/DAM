
public class Pruebas {

	public static void main(String[] args) {
		String fragmentoNombreAlumnos = "Victor";
		String[] nombreAlumnos = {"Antonio", "Marta", "Victor Hugo", "David"};
		
		int resultado = contarUsuarios (fragmentoNombreAlumnos, nombreAlumnos);
		System.out.println("Total resultados: " + resultado);
		
	}

	private static int contarUsuarios(String fragmentoNombreAlumno, String[] nombreAlumnos) {
		boolean encontrado = false;
		int totalEncontrados = 0;
		
		for (String nombreAlumnoActual : nombreAlumnos) {//variable pivote : array , los 2 de tipo string, en el pivote guardas las posiciones del array
			if (nombreAlumnoActual.contains(fragmentoNombreAlumno)) {
				encontrado = true;
				//totalEcontrados ++
			}
			if (encontrado) {
				totalEncontrados++;
				encontrado = false;//Volvemos a poner la bandera en false, pq sino todo lo que venga detras de victor, la estaría contando y sumando
			}						//Como para reiniciar la bandera
		}
	
	//Tambien quitando los booleanos, y cada vez que haga contains, incremente totalEncontrados
		
		
/*	
 * for (int i = 0; i < nombreAlumnos.length-1; i++){
 * String nombre = nombreAlumnos[];
 * }*/	
		return totalEncontrados;
	}
}