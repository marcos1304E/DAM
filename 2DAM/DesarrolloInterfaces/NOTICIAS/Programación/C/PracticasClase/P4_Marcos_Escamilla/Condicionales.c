#include <stdio.h>
#include <stdlib.h>

/*
*    Autor:Marcos
*
*/


/**
        if(pregunta de sí o no){
			Código si respuesta afirmativa
	}

*/
/** OPERADORES DE COMPARADOR SON:
*	>Mayor
*	<Menor
*	<= menor o igual
*	>= mayor o igual
*	== igual
*	!= distinto
*/

int main(){
	int condicion;	// El = es un operador de asignacion
	
	scanf("%d",&condicion);
	case 0:
		printf("Vale 0\n");
		break
	case 1:
		printf("Vale 1\n");
		break
	case 2:		
		printf("Vale 2\n");
		break
	case 3:
		printf("Vale 3\n");
		break		
	
	
	
	scanf("%d",&condicion);
	if(condicion ==0){
		printf("Condicion vale 0");
		else if(condicion ==1)//Es el operador de comparación
		printf("Condicion vale 1\n");

	} else {  if (condicion ==2){
	printf("Condicion vale 2\n");
	} else{
		printf("Condicion no vale ni 0 ni 1\n");
}
return EXIT_SUCCESS;
}}
