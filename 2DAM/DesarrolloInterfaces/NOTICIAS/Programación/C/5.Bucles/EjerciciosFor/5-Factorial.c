#include <stdio.h>
#include <stdio.h>

int main(){

	int tabladel=5;
	int resultado=1;
	int num;
	printf("Escribe un número:\n");
	scanf("%d", &num);

	for(int i =1; i<=num;i++){
		resultado =resultado *i;
	}
	printf("El factorial de %d es %d\n", num, resultado);

	return 0;
}

