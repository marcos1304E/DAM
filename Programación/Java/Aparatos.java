public class Aparatos {

	public static void main(String[] args) {

		AparatosElectronicos bombilla = new AparatosElectronicos(100);
		AparatosElectronicos radiador = new AparatosElectronicos(2000);
		AparatosElectronicos plancha = new AparatosElectronicos(1200);
		
		System.out.println("El consumo actual del sistema es "+AparatosElectronicos.consumo());
	
		bombilla.encender();
		plancha.encender();
		
		System.out.println("El consumo actual del sistema es "+AparatosElectronicos.consumo());
		
		plancha.apagar();
		radiador.encender();
		
		System.out.println("El consumo actual del sistema es "+ AparatosElectronicos.consumo());
		
	}

}
