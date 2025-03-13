#include <stdio.h>
#include <stdlib.h>



int main(){



	for (int i=0 ; i<100/*condicion*/ ; i = i + 2/*Codigo a ejecuitar entre vueltas*/ ){
		//este buycle, asi escrito, no imprime el 100
		//en la ultima ejecucion del bucle i vale 98
		//por tanto, al incrementar i, i vale 100
		//Y,no cumple la condicion


		printf("%d", 1);
	}
	printf("Terminado\n");

	return 0;
}























/**
 * 	1)Inicializo i=0
 * 	2)Compruebo si i<5. Como se cumple, ejecuto el interior del bucle.
 * 	3)Printf
 * 	4)Terminando el interior del bucle, ejecuto el "codigo entre vueltas": i=i+1
 * 	5)Vuelvo al punto 2. Comprueblo si i<5. Se cumple pq i==1. Ejecuto el interior.
 * 	6)Printf
 *	7)Terminando el interiror del bucle, ejecuto: i=i+1. Ahora i vale 2
 *	8)Vuelvo a la condicion: ¿i<5? Sí. Interior del bucle
 *	9)Printf
 *	10)Terminando el interior del bucle, ejecuto i=i+1. Ahora i vale 3
 *	11)Comprobar la condicion. ¿i<5? Si. Interior del bucle
 *	12) 13) i vale 4 14) Condicion: ¿i<5? Si. Interior
 *	15) 16) i vale 5 17) Condicion: ¿i<5? No. Salimos del bucle
 */

