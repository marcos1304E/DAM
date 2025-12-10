#include <stdlib.h>
#include <stdio.h>

int main(){

	int n, contador = 0;

	printf("Introduce un numero entero positivo:\n");
	scanf("%d",&n);

	for (int i = 1; i <= n; i++){
		if(n % 1 == 0){
			contador++;
		}
	}

printf("El numero %d tiene %d divisores\n",n,contador);
return 0;
}
