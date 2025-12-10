#include <stdlib.h>
#include <stdio.h>
int main(){

//
//Autor:Marcos Escamilla Ojedaç
//1ºDAM
//Programación


	float numero1, numero2, resultado;
	char operador;
	
	printf("Escribe el primer número: \n");
	scanf("%f", &numero1);
	printf("Escribe el segundo número: \n");	
	scanf("%f", &numero2);

	printf("Escribe el operador que quieres utilizar:\n");
	scanf(" %c", &operador);

	switch (operador){
		case '+':
			resultado= numero1 + numero2; //Aquí se introduce un case para cada operador
			printf("El resultado es= %f\n", resultado);
			break;
	case '-':
			resultado= numero1-numero2;
			printf("El resultado es= %f\n", resultado);
			break;
	case '*':
			resultado= numero1 * numero2;
			printf("El resultado es= %f\n", resultado);
			break;

	case '/':
			resultado= numero1 / numero2;
			printf("El resultado es= %f\n", resultado);
	default:		

			printf("El operador no es valido\n");
		return 0;
	}}	
