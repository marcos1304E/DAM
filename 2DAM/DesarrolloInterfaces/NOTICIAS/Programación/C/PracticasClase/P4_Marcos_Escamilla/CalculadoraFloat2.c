#include <stdio.h>
#include <stdlib.h>

/**
 *  wdwd
 *  wdada
 */

float suma(float a,int b){
	return a+b;
} 
float resta(float a, float b){
	return a-b;
}
float multiplicacion(float a, float b){
	return a*b;
}
float division(float a, float b){
	return a/b;
}

int main(){
	float numero1, numero2;
		printf("Escribe el primer número:\n ");
		scanf("%f",&numero1);
		printf("Escribe el segundo número:\n ");
		scanf("%f",&numero2);

		printf("La suma es= %f\n", suma (numero1, numero2));	
		printf("La resta es= %f\n", resta (numero1, numero2));	
		printf("La multiplicacion es= %f\n", multiplicacion (numero1, numero2));	
		printf("La división es= %f\n", division (numero1, numero2));	

		return 0;
}



		

