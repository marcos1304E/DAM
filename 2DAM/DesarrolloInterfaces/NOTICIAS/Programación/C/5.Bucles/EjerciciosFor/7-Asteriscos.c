#include <stdlib.h>
#include <stdio.h>

int main(){

	int n;

	printf("Introduce un número:\n");
	scanf("%d", &n);
	
	for (int i=1;i<=n;i++){
	for (int j=1; j<=n;j++){
		printf("*");
	}
	printf("\n");
	}
	printf("\n");
	return 0;
	}
