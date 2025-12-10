#include <stdio.h>
#include <stdlib.h>

int main(){

	int numero1, numero2;
	float resultado_suma, resultado_resta, resultado_multiplicacion, resultado_division;


	   printf("Escribe el primer numero. ");
	   scanf("%d",&numero1);
	    printf("Escribe el segundo numero. ");
	    scanf("%d",&numero2);


	resultado_suma= (float)numero1+numero2;
	 resultado_resta= (float)numero1-numero2;
	  resultado_multiplicacion= (float)numero1*numero2;
	   resultado_division= (float)numero1/numero2;
	    printf("Suma=%.2f\n", resultado_suma);
	    printf("Resta=%.2f\n", resultado_resta);
	    printf("Multiplicacion=%.2f\n", resultado_multiplicacion);
	    printf("Division=%.2f\n", resultado_division);
 return 0;}
