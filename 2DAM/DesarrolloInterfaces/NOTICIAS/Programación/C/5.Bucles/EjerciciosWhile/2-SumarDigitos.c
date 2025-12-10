#include <stdio.h>
#include <stdlib.h>


int main(){

	int n,cociente,resto = 0;
	printf("Introduce un numero entero:\n");
	scanf("%d",&n);



	do{	
		cociente = n / 10;
		resto += n % 10;
		n = cociente;
	}while (cociente != 0);

	printf("%d\n",resto);



return 0;
}
