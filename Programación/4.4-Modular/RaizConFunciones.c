#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/**
 *   gygyggygy
 * 
 *   autor:marcosE
 */
int calcularRaiz(){
	int valor;
	double raiz;

	// PARTE DEL CÁLCULO DE UNA RAIZ CUADRADA
	printf("Introduzca un número para calcular su raiz\n");
	scanf("%d",&valor);
	raiz = sqrt(valor);
	printf("La raiz cuadrada de %d es %lf\n", valor,raiz);
	
	return 0;//como ha ido bien, devuelve un 0.
}

void calcularArea(){

	double radio,area;
		

	//parte del cálculo del area del circulo
	printf("Introduzca el radio del circulo para calcular su área\n");
	scanf("%lf",&radio);
	area= radio * radio * M_PI; //M_PI está definido en math.h. Es una constante con el valor de pi.
	printf("El área del circulo es %lf/n",area);

}


int main(){
		int respuesta = calcularRaiz();

		calcularRaiz();
		calcularRariz();
		
		 calcularArea();
		 calcularArea();
		 calcularArea();

return 0;
	}
