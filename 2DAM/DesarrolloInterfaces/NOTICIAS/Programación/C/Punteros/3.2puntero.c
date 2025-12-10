#include <stdio.h>
#include <stdlib.h>

int main()
{
	long arr[5] = {10, 20, 30, 40, 50};
	//La variable p tiene que apuntar "al final"
	int *p;
	p = arr+5;//cuando accedes a la arr[5] accedes a la 6 posicion.. accedo a una memoria y cojon su direccion, puede romper programa-- no quiero acceder a memoria, ya que revienta
		  
		  	
	for (int i = 5; i >0; i--) {
		printf("Elemento %d: %d\n", i, *(p - i));
	}
}
