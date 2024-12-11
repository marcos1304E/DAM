#include <stdio.h>
#include <stdlib.h>

int main(){
//crea un programa que pida por pantalla un numero entero y cree un array de enteros de ese tamaño inicializando con los números pares. Despues imprimelo
																//Modifica el puntero para que sea un array el doble de grande y, en la segunda parte del array, se guarden los números impares

	int n;

	printf("introduce un numero entero:\n");
	scanf("%d", &n);

	int *arrPares = (int *)malloc(n*sizeof(int));

	if (arrPares == NULL){
		printf("Error, no se pudo asignar memoria.\n");
		return EXIT_FAILURE;
	}

	for (int i = 0; i < n; ++i)
	{
		arrPares[i] = i * 2;
	}

	//PRINT DE PARES

	for (int i = 0; i < n; ++i)
	{
		printf("arr[%d]: %d\n", i,arrPares[i]);
	}

	//REHACES EL ARRAY CON EL DOBLE DE TAMAÑO. REALLOC


	int * arrImpares = (int *)realloc(arrImpares,2*n*sizeof(int));
	if (arrPares == NULL)
	{
		free(arrPares);
		printf("Error de realloc");
		return EXIT_FAILURE;
	}
	arrPares = arrImpares;

	for (int i = n,valor = 1; i < 2*n; ++i,valor +=2)
	{
	arrPares[i] = valor;
	}
	for (int i = 0; i < 2*n; ++i)
	{
	printf("arr[%d]: %d\n", i);
	}


	free(arrPares);



return 0;
}