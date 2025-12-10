#include <stdio.h>
#include <stdlib.h>

int main() {
    int tamaño_array;

    // Paso 1: Solicitar al usuario un número entero positivo
    printf("Introduce un número entero positivo para determinar el tamaño del array: ");
    scanf("%d", &tamaño_array);

    // Validar que el número sea positivo
    while (tamaño_array <= 0) {
        printf("Por favor, ingresa un número positivo: ");
        scanf("%d", &tamaño_array);
    }

    // Paso 2: Crear un array de enteros con el tamaño especificado
    int *array = (int *)malloc(tamaño_array * sizeof(int));

    // Verificar si se pudo asignar memoria
    if (array == NULL) {
        printf("Error al asignar memoria.\n");
        return 1;
    }

    // Inicializar el array con ceros
    for (int i = 0; i < tamaño_array; i++) {
        array[i] = 0;
    }

    // Mostrar el array (con valores inicializados a 0)
    printf("El array con %d elementos es: \n", tamaño_array);
    for (int i = 0; i < tamaño_array; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    // Liberar la memoria
    free(array);

    return 0;
}