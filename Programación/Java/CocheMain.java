public class CocheMain {

	public static void comprobar(Coche cocheArray[], int i) {
		
		if(cocheArray[i].unCoche == TipoCoche.DEPORTIVO) {
			
			System.out.println("Deportivos: "+cocheArray[i]);
			
			} else if(cocheArray[i].año_fabricacion % 2 == 0) {
				
				System.out.println("Año de fabricacion par: "+ cocheArray[i]);
				
			}
		
	}

	public static void main(String[] args) {
		
		/*crear varios objetos y mostrar caracts. mostrar todos los coches deportivos y fecha de fabricacion es par*/
		Coche[] cocheArray = {
			
		 
		new Coche("AUDI", "rojo", true, "1234ABC", TipoCoche.MINI, 2003, seguro.A_TODO_RIESGO),
		
		new Coche("FORD", "negro", false, "1234DEF", TipoCoche.DEPORTIVO, 2020, seguro.TERCERO),
		
		new Coche("DACIA", "verde", false, "1234GHI", TipoCoche.UTILITARIO, 2015, seguro.TERCERO),
		
		new Coche("BMW", "azul", true, "5678JKL", TipoCoche.DEPORTIVO, 2017, seguro.A_TODO_RIESGO),

		new Coche("RENAULT", "blanco", false, "9101MNO", TipoCoche.FAMILIAR, 2021, seguro.TERCERO),

		new Coche("SEAT", "gris", true, "1121PQR", TipoCoche.DEPORTIVO, 2013, seguro.A_TODO_RIESGO),
		
		
		};			
		
			
		for(int i = 0; i < cocheArray.length; i++) {
			System.out.println(cocheArray[i]);
		}
		
		System.out.println();
		System.out.println("Coches que cumplen los requisitos: ");
		System.out.println();
		
		for(int i = 0; i < cocheArray.length; i++) {
			comprobar(cocheArray, i);
		}
		

	}
	
	
}
