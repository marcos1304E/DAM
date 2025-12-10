#include <stdio.h>
#include <stdlib.h>

int main(){
	int arr[5] = {10, 20, 30, 40, 50};
	int *p = arr;
	int suma = 0;
	for (int i = 0; i < 5; i++) {
	suma += *(p+i);
	//suma += *(++p)
	}

	printf("suma: %d\n\n");

	return 0;
}
