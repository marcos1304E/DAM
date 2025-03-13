#include <stdio.h>
#include <stdlib.h>

/**
 * *
 * *	Marcos Escamilla
 * */

struct fecha {
	int mes;
	int dia;
	int anio;
};

struct cuenta {
	int num_cuenta;
	char tipo_cuenta;
	char nombre[80];
	float saldo;
	struct fecha ultimopago;
};

int main(){

	struct cuenta cliente[100];
	/**Declarando hueco para 100 cuentas.*
	 *
	 **Esta forma de inicializar solo es válida en la declaración:*/
	struct cuenta usuario = {12345, 'R', "José",586.30,5,24,1990};
	//num_cuenta, tipo_cuenta, nombre, saldo, fecha.mes,fecha.dia,fecha.anio		

	printf("Num cuenta:%d\n", usuario.num_cuenta);
	printf("Tipo cuenta:%d\n", usuario.tipo_cuenta);
	printf("Día del último pago:%d\n", usuario.ultimopago.dia);

	/**Array de clientes*/
	cliente[0].num_cuenta = 12345;
	cliente[0].tipo_cuenta = 'R';

	cliente[0].saldo = 586.30;
	cliente[0].ultimopago.mes = 5;
	cliente[0].ultimopago.dia = 24;
	cliente[0].ultimopago.anio = 1990;
	//strcpy(cliente[0].nombre, "José");  



	// Usar strcpy para copiar cadenas en C

	printf("%d",cliente[0].tipo_cuenta);

	//Rellenamos el segundo cliente por pantalla
	printf("Introduce el numero de cuenta

	return EXIT_SUCCESS;
}
