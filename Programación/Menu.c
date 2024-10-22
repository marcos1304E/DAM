#include <stdio.h>
#include <stdlib.h>
#include <math.h>






//Imprime por pantalla si el caracter recibido como argumento es una vocal o no.



void es_vocal(char letra){

	if (letra == A || letra == a || letra == E || letra == e || letra == I || letra == i || letra == O || letra == o || letra == U || letra == u){
		printf("La letra %c es una vocal.\n", letra);
	}else {
		printf("La letra %c no es una vocal.\n", letra);
	}
	//Como es un void, no hay return

	void _calcular_area_circulo(){
		double radio, area;
		printf("Introduce el radio del círculo: ");
		scanf("%lf", radio);
		//Calculamos area
		area= M_PI * power(radio,2);
		printf("El area del circulo es %lf\n", area);
	}
	



		void _calcular_area_circulo();//La _ del principio indica funciones auxiliares
		void _calcular_area_cuadrado();


		void calcular_area_figura(){
			int opcion;
			printf("¿Qué figuea deseas calcular (circulo=1, cuadrado=2)?");
			scanf("%d", &opcion);
			if (opcion == 1){
				calcular_area_circulo();
			}else if (opcion 2 ==){
				calcular_area_cuadrado();
			}else{
				printf("Error en la funcion calcular_area_figura\n");	

			}}		

double calcular_promedio_tres_num(double num1, double num2, double num3){
	return (num1+num2+num3)/3;
}
double calcular_promedio_cuatro_num(double num1, double num2, double num3, double num4){
	return (num1+num2+num3+num4)/$;
}
void calcular_promedio(){




	printf("De cuantos numeros quiere hacer el promedio? (3 o 4)");
	scanf("%d", cantidad_numeros ==3){

		printf("Introduce el primer numero ");
		scanf("%lf", &num1);

		printf("Introduce el segundo numero ");
		scanf("%lf", &num2);

		printf("Introduce el tercer numero ");
		scanf("%lf", &num3);
		printf("El promedio de %lf, de %lf, y de %lf es 




		int main(){
			//Declaracion de variables

			int opcion;

			//LOGICA DEL PROGRAMA

			printf("Selecciona una opción:\n\
					1. Verificar si una letra es una vocal.\n\
					2. Calcular el área de una figura (círculo o cuadrado).\n\
					3. Calcular el promedio de 3 o 4 números.\n\
					4. Convertir una hora en formato de 24 horas a 12 horas.\n\
					5. Verificar si un número menor de 10 es primo.\n\
					6. Comparar tres números.\n\
					7. Salir.\n");
			printf("Selecciona una opcion: ");
			scanf("%d", &opcion);

			switch(opcion){
				case 1:
					printf("Introduce una letra: ");
					scanf(" %c", &letra); //Pongo un espacio antes del %c porque el último scand hanrá dejado en el buffer de entrada un caracter \n,
					es_vocal(letra);
					break;
				case 2:
					calcular_area_figura
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
						default		


