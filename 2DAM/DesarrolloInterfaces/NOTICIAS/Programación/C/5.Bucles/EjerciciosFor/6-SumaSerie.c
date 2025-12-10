#include <stdio.h>
#include <stdlib.h>

int main(){


int n;
int suma =0;
printf("Escribe un número:\n");
scanf("%d",&n);

for(int i=1; i<=n;i++){
	
suma=suma+i;}
	printf("La suma de los numeros del 1 al %d es: %d\n",n,suma);

return 0;
}

	
