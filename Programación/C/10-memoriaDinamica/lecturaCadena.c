#include <stdio.h>
#include <stdlib.h>

int main(){

	int n;
	char cadena;

	scanf("%d",&n);

	char * arr = (char *)malloc(n*sizeof(char));

	if (arr == NULL){
		printf("Error, no se pudo asignar memoria.\n");
		return EXIT_FAILURE;
	}



	for (int i = 0; i < n; ++i)
	{
		scanf("%s", &arr[i]);
		printf("arr[%d]: %s\n", i,&arr[i]); 
	}

	free(arr);
	return 0;
}
