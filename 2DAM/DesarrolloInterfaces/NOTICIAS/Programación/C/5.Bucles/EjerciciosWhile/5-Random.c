#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){

	int r;

	//srand(10);
	srand(time(NULL)); //Cambia cada segundo
	//srand(getpid()); //Identificador del proceso
	for(int i = 0;i<4;i++){
		//srand(10); esto provocaria que se calculara siempre el msimo numero aleatorio
		r = (rand() % 5) +1
		       //Rand genera aleatorio entre 0 y 4 incluidos.
		       //Al sumar 1, consigo numeros aleatoprios entre 1 y 5
		     	
	//Hacer moduloo 8 da numeros aleatorios entre 0 y 7º
		printf("%d\n",r);

	}
	return 0;
}
/**
 * Construir una funcion que calcule un numero aleatorio entre dos valores dados como argumento
