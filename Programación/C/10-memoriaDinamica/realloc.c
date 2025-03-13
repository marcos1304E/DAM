#include <stdio.h>
#include <stdlib.h>

int main(){

int n = 3;

int * arr = (int *) malloc (3*sizeof(int));

//SIEMPRE
if(arr = NULL){
	printf("Error fatal, no hay memoria\n");
	return EXIT_FAILURE;

}

for(int i=0; i < n; i++){
	printf("arr[%d] = %d\n", i, arr[i]);
}

//inicializa los valores del array con los numeros 1,2 y 3

//inicializacion basica
arr[0]=1;
arr[1]=3;
arr[2]=5;

//inicializacion pro
for (int i = 0; i < 3; ++i)
{
	arr[i] = 2*i+1;
}

/*for (int i = 0; i < 3; i++,j+=2)
{
	arr[i] = j;
}
*/

//ampliar array a 5 elementos
int * arr_ampliado = (int *) realloc(arr,5*sizeof(int));

if (arr_ampliado == NULL)
{
	free(arr); //realloc no libera la memoria antigua
	printf("Error, no se ha podido redimensionar\n");
	return EXIT_FAILURE;
}

//Para evitar confusiones entre arr_ampliado y arr, es recomendable añadir:
// arr = arr_ampliado;


//MALA PRACTICA: arr se ha quedado "colgando"


//Terminamos de inicializar
arr_ampliado[3] = 7;
arr_ampliado[4] = 9;

for (int i = 0; i < 5; ++i)
{
	printf("arr_ampliado[%d]: %d", i, arr_ampliado[i]);
}


//¿Que tengo que liberar?

free(arr_ampliado);
free(arr);

return 0;
}
