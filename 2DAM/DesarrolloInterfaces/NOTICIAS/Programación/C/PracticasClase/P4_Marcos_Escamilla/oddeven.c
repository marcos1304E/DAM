#include <stdio.h>
#include <stdlib.h>

//
//Autor:Marcos Escamilla Ojeda
//1ºDAM
//Programación
int main(){
	int condicion;
	char numero;
	
	printf("Escribe un número entero: ");		
	scanf("%d", &condicion);
		numero= ! (condicion % 2) ? 'P' : 'I'; //'I' para número impar, y 'P' para número par
		printf("%c\n", numero);

		return 0;
}

