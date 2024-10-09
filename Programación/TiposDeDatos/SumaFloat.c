#include <stdio.h>
#include <stdlib.h>


int main (){
	float numero1=2.34;
	float numero2=2.5;
	float resultado_suma, resultado_resta, resultado_multiplicacion, resultado_division;


	printf("Escribe el primer numero: ");
	scanf("%f", &numero1);
	printf("Escribe el segundo numero: ");
	scanf("%f", &numero2);

	resultado_suma= numero1+numero2;
	resultado_resta= numero1-numero2;
	resultado_multiplicacion= numero1*numero2;
	resultado_division= numero1/numero2;

	printf("Suma=%.2f\n", resultado_suma);
	printf("Resta=%.2f\n", resultado_resta);
	printf("Multiplicacion=%.2f\n", resultado_multiplicacion);
	printf("Division=%.2f\n", resultado_division);

	return 0;
}
