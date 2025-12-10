#include <stdio.h>
#include <stdlib.h>



//
//
//Autor: Marcos Escamilla
//Desarrollo de Aplicaciones Multiplataforma
int comparar(void * p1,void * p2){
	//Comparar
}

//*ptr será lo que hay que imprimir
//tipo indiac el tipo de variable


void printValor(void * ptr, char tipo){

	switch(tipo){
		case 'd':
			printf("Double %lf\n",*((double *)ptr));//Para acceder al contenido del puntero
			break;

		case 'i':
			printf("Entero: %d\n", *((int *)ptr ));
			break;
		default:
			printf("Error");

	}
}
	int main(){
		double num = 2.1;
		void * dir = &num;
		printValor(dir,'d');
		printf("%ld\n",sizeof(dir));


		return 0;
	
	}
