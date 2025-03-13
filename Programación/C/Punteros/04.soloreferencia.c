#include <stdio.h>
#include <stdlib.h>



//
//Autor: Marcos Escamilla
//Desarrollo de Aplicaciones Multiplataforma

//Ejemplo de paso de un argumento a una función por valor


//Quiero que realmnente incremente la variable dada como argumento
void incrementar(int *n){
	printf("Valor recibido: %d\n", *n);
	//n++;
	*n = *n + 1;
	printf("Valor incrementado en la función: %d\n",*n);
}//La funcion incrementar recibe dir de memoria dnd se almacena el 10, toca el 10 real, toca contenido de esa dir de memoria, cambion de 10 a 11, tambien accede el main, el contenido de memoria del 10, está en esa direccion en concreo
 //esto permite hacer funciones de verdad

int main(){
	int valor = 10;
	incrementar(valor); //Le estoy dando EL VALOR 10, no la variable
	printf("Valor: %d",valor); //Imprime un 10









	return 0;
}
