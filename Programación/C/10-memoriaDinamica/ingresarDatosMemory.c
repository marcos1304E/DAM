#include <stdio.h>
#include <stdlib.h>

int main(){

	int n;

		scanf("%d", &n);

			int *arr = (int *)malloc(n*sizeof(int));

			if (arr == NULL){
		printf("Error, no se pudo asignar memoria.\n");
		return EXIT_FAILURE;
	}



	for (int i = 0; i < n; ++i)
	{
		scanf("%d", &arr[i]);
		printf("arr[%d]: %d\n", i,arr[i]); 

	}

	free(arr);


return 0;
}

