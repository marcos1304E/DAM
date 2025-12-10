#include <stdio.h>
#include <stdlib.h>



//
//Autor: Marcos Escamilla
//Desarrollo de Aplicaciones Multiplataforma

//Ejemplo de paso de un argumento a una función por valor
void incrementar(int n){
	printf("Valor recibido: %d\n", n);
	n++;
	printf("Valor incrementado en la función: %d\n",n);
}

int main(){
	int valor = 10;
	incrementar(valor); //Le estoy dando EL VALOR 10, no la variable
	printf("Valor: %d",valor); //Imprime un 10



//uno para leer y otro para modificar,
	//cuando paso dir de memoria es para modificar//por referencia
	//el paso por valor es para leer
	//cuando llamamos a una funcion, crea variables nuevas, que guardamos (valor o dir de memoria)






	return 0;
}
