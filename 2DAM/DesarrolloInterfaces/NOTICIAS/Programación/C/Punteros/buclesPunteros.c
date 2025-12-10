#include <stdio.h>
#include <stdlib.h>

/**
 * Autor: Marcos Escamilla
 *
 */

int main(){

	int arr[5] = {1,2,3,4,5};

	//Recorrer el array y sumarlo
	for (int * p = arr; *p <=5;p++){
		printf("%d",*p);
	}
	for (int * p;*p <= 5; p++){
		printf("%d", *p);
	}
	 printf("Sizeof arr: %ld\n", sizeof(arr));
	 printf("Sizeof int: %ld\n", sizeof(int));
	 printf("Elementos del array: %ld\n", sizeof(arr)/sizeof(int));

	char palabra[10] = "gratis";
	for (char * l = palabra; *l != '\0'; l++){
		printf("%c",*l);
	
	printf("\n");}
	return 0;
}

/*
 * arr = [1][2][3][4][5] $
 * 	*p = 1 <= 5 sí
 * 	entro al bucle
 * 	print -->
 * 	p++;
 * 	*p=2;(*p<=5)??? si
 *
 * 	p++
 * 	*p=3; <= 5 sí
 *
 * 	p++
 * 	*p = 4 --> **p <=5??? si
 * 	print--> 4
 * 	p++
 * 	*p = 5 --> ¿5<=5? si
 * 	print --> 5
 * 	p++
 * 	*p=$
 */
