#include <stdio.h>
#include <stdlib.h>

int main(){

	int * dir;
	printf("Direccion de memoria:%p\n",dir);
	printf("Contenido de esa direccion:%d\n",*dir);
	return 0;
}
