public class AparatosElectronicos {
	
	  	static int consumoTotal = 0;
	   
	   	static int consumo(){
	  		return consumoTotal;
	  	}
	   
	   	int potencia;
	  	boolean encendido;
	  
	 	public AparatosElectronicos (int potencia){
	  		this.potencia= potencia;
	  		encendido = false;
	  	}
	  
	  	public void encender(){
	   		if(!encendido){
	   			encendido = true;
	   			consumoTotal+=potencia;
	   		}	
	   	
	   	}
			
			public void apagar(){
				if(encendido){
					encendido = false;
					consumoTotal -= potencia;
				}
			}    		
	  
}	 

