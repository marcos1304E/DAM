#include <stdio.h>
#include <stdlib.h>

int main(){
//
//Autor: Marcos Escamilla Ojeda
//1º Dam
//Programación

	int numero;
	
	printf("Escribe un número del 1 al 7: \n");
	scanf("%d", &numero);

	switch (numero){	//Aquí poner en cada caso un número correspondiendo a cada día de la semana
		case 1:
			printf("Lunes\n");
		break;
		case 2:
			printf("Martes\n");
		break;
		case 3:
			printf("Miercoles\n");
		break;
		case 4:
			printf("Jueves\n");
		break;
		case 5:
			printf("Viernes\n");
		break;
		case 6:
			printf("Sabado\n");
		break;
		case 7:
			printf("Domingo\n");
		break;	
		default:
			printf("Número inválido\n");
		
	}return 0;
	}	
