#include <stdio.h>
#include <stdlib.h>

/*
Marcos Escamilla Ojeda
DAM
Programación
*/

void modificar_elemento (int *array, int tam,int valor){

if(tam > 0){
	array[tam - 1] = valor;
}
	printf("Valor recibido: %d\n", valor);

	valor++;
	printf("Valor incrementado en la función: %d\n",valor);
}

void modificar_por_referencia(int * valor, int *array){

	int * arr_ampliado = (int *) realloc(array, *valor*sizeof(int));

	
free(arr_ampliado);
}
int main(){

	int tamaño_array;
int n;

    //Solicitamos al usuario un número entero positivo
    printf("Introduce un número entero positivo para determinar el tamaño del array: ");
    scanf("%d", &tamaño_array);


    // Valido que el número sea positivo
    while (tamaño_array <= 0) {
        printf("Por favor, ingresa un número positivo: ");
        scanf("%d", &tamaño_array);
    }


    // creo un array de enteros con el tamaño especificado
    int *array = (int *)malloc(tamaño_array * sizeof(int));

    // Verificar si se pudo asignar memoria
    if (array == NULL) {

        printf("Error al asignar memoria.\n");
        return 1;
    }

    for (int i = 0; i < tamaño_array; ++i)
	{
		scanf("%d", &array[i]);
		printf("arr[%d]: %d\n", i,array[i]); 

	}

	//Mi idea era hacer dos bucles, uno que imprima el array antes de ser modificado, y otro con el array ya modificado

	//imprimimos el array con los numeros ingresados por el usuario


	/*int menu;
printf("valor o referencia \n");
        scanf("%d", &menu);

        switch (menu){

        case "valor":
        	modificar_elemento(*valor);

        case "referencia":
        	modificar_por_referencia(valor, array);

}
*/
	int valor = 10;
	


/*Tenemos dos partes diferentes del codigo donde una se pasa por valor, y otra por referencia, cuando pasamos por valor, se hace una copia de la variable, y ahi podemos modificar la variable, pero no modificamos la variable original. Cuando pasamos por referencia, ahí modificamos la direccion de la memoria de la variable, si pudiendo modificarla, con la utilizacion de punteros.
Cuando le paso la direccion de memoria es para modificar, y el paso por valor es para leer. Nosotros cuando llamamos a una funcion, creamos unas variables nuevas, que guardamos, ya sea valor o direccion de memoria*/
	free(array);
	

return 0;
}
