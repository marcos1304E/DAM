#include <stdio.h>
#include <stdlib.h>

//
//Autor:Marcos Escamilla Ojeda
//1ºDAM
//Programación


int main(){
	char rol;
	float MontoSinDescuento, MontoConDescuento;

	printf("Escribe tu monto total de compra:\n ");
	scanf("%f", &MontoSinDescuento);

	printf("Escribe tu rol:\n ");
	scanf(" %c", &rol);

	if (rol=='E'){ //Ponemos una E, si es un estudiante
		MontoConDescuento = MontoSinDescuento * 0.85;
	} else 
	if(rol=='P'){ //Ponemos una P, si es profesor
		MontoConDescuento = MontoSinDescuento * 0.9;
	} else 
	if(rol=='O'){ //Ponemos una O, si es otro
		MontoConDescuento = MontoSinDescuento;
	} else{
		MontoConDescuento = MontoSinDescuento;
	}

	printf("El monto final con el descuento es: %.2f\n", MontoConDescuento);
	return 0;
}


