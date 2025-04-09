import java.util.Scanner;

public class PedirN {

	public static void main(String[] args) {
		
		
		
		
		/* Scanner
		 * int n = 0;
		 * syso introduce cant de nunmeros
		 * 
		 * n = entrada.nextInt();
		 * 
		 * int [] arrays = new int [n];
		 * 
		 * 
		 * for(int i=0; i < n;i++){
		 * 		syso introduce numero
		 * 		array[i]=entrada.nextInt();
		 * }
		 * 
		 * for(int i = 0; i < n; i++){
		 * 		syso array[i]
		 * 	}
		 *  
		 *int max = array[0], min= array[0]
		 *
		 *for(int i = 1; i < n; i++){
		 *		if(array[i]<min){
		 *			max = array[i];
		 *		
		 *		}else{
		 *			if(array [< min]){
		 *				min = array[i]
		 *			}
		 *		}
		 *}
		 *
		 *int cantMax=0, cantMin=0;
		 *
		 *for(int i =0; i < n; i++){
		 *
		 *
		 *}
		 *cant++
		 *o
		 *cant++
		 *
		 *syso
		 *syso
		 *
		 * br////////////////////////
		 * 
		 * int 4 variables,
		 * 
		 * for{
		 * syso introduce numero
		 * 
		 * numeros[i]=entrada.nextInt();
		 * entrada.nextLine();
		 * 
		 * if i == 0{
		 * 
		 * maximo=numeros[i]
		 * minimo=numeros[i]
		 * }
		 * if numeros de i > maximo{
		 * 	maximo = numeros[i]
		 * repMax = 0;
		 * }else{
		 * 	if numeros[i] < minimo {
		 * 	minimo = numeros de i
		 * repMin = 0;	
		 * }
		 * }
		 * 
		 * if maximo == numeros de i
		 * repMax ++
		 * 
		 * 
		 * 
		 * lo mismo con el minimo
		 *
		 *
		 * */
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un número");
		int n = entrada.nextInt();
		int numeros[] = new int [n];

		
		for(int i= 0; i < n; i++) {
			System.out.println("Introduce numero:");
			numeros[i]= entrada.nextInt();
				
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i+1;j++) {
				if (numeros[i] > numeros[j]) {
					System.out.println("el numero menor es "+numeros[j]);
				}
			}
		}
		
		
		
		
		entrada.close();
	}
	
	
}
