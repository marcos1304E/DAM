#include <stdio.h>
#include <stdlib.h>

int main(){
	int numero1=2;
	int numero2=1;
	int resultado_suma, resultado_resta, resultado_multiplicacion,resultado_division;
      
      resultado_suma= numero1+numero2;
      resultado_resta=numero1-numero2;
      resultado_multiplicacion=numero1*numero2;
      resultado_division=numero1/numero2;
      printf("Escribe el primer numero: ");
	      scanf("%d", &numero1);

	      printf("Escribe el segundo numero: ");
	      scanf("%d", &numero2);
	      printf("Suma=%d\n", resultado_suma);
	      printf("Resta=%d\n", resultado_resta);
	      printf("Multiplicacion es %d\n", resultado_multiplicacion);
	      printf("La division es %d\n", resultado_division);
	      return 0;
}

	
