#include <stdio.h>
#include <stdlib.h>

//
//Autor:Marcos Escamilla Ojeda
//1ºDAM
//Programación
int main(){
	int edad;

	printf("Escribe la edad: ");
	scanf("%d", &edad);

	if (edad <12){ 
		printf("Grupo: Niño\n");
	}else if (edad >= 12 && edad <=17){
		printf("Grupo: Adolescente\n");
	}else if (edad >=18 && edad <=64){
		printf("Grupo: Adulto\n");
	} else if (edad >=65){
		printf("Grupo: Mayor\n");
	}
	return 0;
	}	
