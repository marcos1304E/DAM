public class EjemploBucleFor {
    
	public static void main(String[] args) {
        	int notas[] = {7, 4, 6, 8, 3};
        	boolean suspensos = false;
		int s = 0;
        		
		for (int i = 0; i < 5; i++) {
	            System.out.println("Nota: " + notas[i]);
            
            		if (notas[i] < 5){ 
                	suspensos = true;
			s++;
			}	

        	}
        
        	if (suspensos)//si suspensos es true significa que hay minimo 1 suspenso, entonces imprime, con la cantidad adecuada de veces que se haya incrementado 's', dependiendo de los suspensos
            	System.out.println("Hay alumnos suspensos." +s);
        	else
            	System.out.println("No hay suspensos.");
    	}	
}

