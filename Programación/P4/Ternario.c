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
char c;		
	scanf("%d",&condicion);
	
	c = (condicion % 2) ? 'I': 'P';
	/* Es equivalente a:
	 * 	if(condicion > 5){
	 * 		c='S';
	 * 	} else{
	 * 		c='N';
	 * 	}*/		

	printf("%c",c);
	


return EXIT_SUCCESS;
}
