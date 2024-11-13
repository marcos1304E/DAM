#include <stdio.h>
#include <stdlib.h>

//
//Autor: Marcos Escamilla Ojeda
//1ºDam
//Programación

int main (){
	float nota;
	printf("introduce la clasificación: ");
	scanf("%f", &nota);

   	(nota >=5) ? printf("Has aprobado\n") : printf("Has suspendido\n"); //Aquí se pone en cada caso una opción u otra
	
	return 0;
}

