#include <stdio.h>
#include <stdlib.h>

int main(){

	int n;



	printf("introduce un numero entero:\n");
	scanf("%d", &n);


	float * arr = (float *)malloc(n*sizeof(float));

	if (arr = NULL)
	{
		printf("Error");
	
		return 1;
	}


	for (int i = 0; i < n; ++i)
	{

		arr[i]= (float) i / n; 

	}


for (int i = 0; i < n; ++i)
{
	printf("Posicion: %d, %.2f", i, arr[i]);

}



float * arr_reducido = (float *) realloc(arr,sizeof(float)*n/2);

if (arr_reducido == NULL)
{
	free(arr); //realloc no libera la memoria antigua

	printf("Error, no se ha podido redimensionar\n");

	return EXIT_FAILURE;
}

for (int i = 0; i < n; ++i)
{
	printf("Posicion: %d, %.2f", i, arr_reducido[i]);

}


free(arr_reducido);
free(arr);
return 0;
}
