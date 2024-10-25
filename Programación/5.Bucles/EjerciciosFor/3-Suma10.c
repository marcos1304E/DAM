#include <stdio.h>
#include <stdlib.h>

int main(){

	int i;
	int suma=0;
	for(i = 1; i<=10; i++){

		printf("%d + %d=", suma,i);

		suma = suma + i;
		printf("%d\n", suma);
	}
	return 0;
}
