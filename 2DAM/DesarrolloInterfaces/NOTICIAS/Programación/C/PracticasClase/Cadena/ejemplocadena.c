#include <stdio.h>
#include <stdlib.h>

int main(){
	char str1[100];
	char str2[200];
	printf("Introduce un número:");
	scanf ("%s",str1); //No hace falta & pq la variable marca la dir de memorioa dnd empieza la cadena, entonces cons aber dnd empieza y el \0 no necesito saber nada más
	printf("Introduce un número:");
	scanf("%s\n",str2);
	printf("%s+%s\n", str1,str2);
	return 0;
}
