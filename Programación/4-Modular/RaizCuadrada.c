#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/**
 *   gygyggygy
 * 
 *   autor:marcosE
 */
int main(){
	double raiz;
	int valor;
		
	double radio,area;

	// PARTE DEL CÁLCULO DE UNA RAIZ CUADRADA
	printf("Introduzca un número para calcular su raiz\n");
	scanf("%d",&valor);
	raiz = sqrt(valor);
	printf("La raiz cuadrada de %d es %lf\n", valor,raiz);
	
	//parte del cálculo del area del circulo
	printf("Introduzca el radio del circulo para calcular su área\n");
	scanf("%lf",&radio);
	area= radio * radio * M_PI; //M_PI está definido en math.h. Es una constante con el valor de pi.
			printf("El área del circulo es %lf/n",area);

return 0;
}

