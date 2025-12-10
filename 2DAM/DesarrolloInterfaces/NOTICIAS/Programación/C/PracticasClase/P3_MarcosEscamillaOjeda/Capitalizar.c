#include <stdio.h>
#include <stdlib.h>

char capitalizar(char letra_minuscula){

return letra_minuscula -32;//Equivale en la tabla ASCII al cambio a mayuscula
			   
}

	int main(){
		char letra;

		printf("Introduce la minuscula:\n ");
		scanf(" %c", &letra);
		char letra_mayuscula=capitalizar(letra);
		printf("La mayuscula es: %c\n", letra_mayuscula);

		return 0;
	}

