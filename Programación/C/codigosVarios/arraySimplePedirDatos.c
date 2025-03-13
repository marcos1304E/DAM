#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    
    // Pedir tamaño del array
    printf("Ingrese el número de elementos: ");
    scanf("%d", &n);
    // Reservar memoria para el array
    int *array = (int *)malloc(n * sizeof(int));
    if (array == NULL) {
        printf("Error al asignar memoria\n");
        return 1;
    }
    
    // Llenar el array con valores
    printf("Ingrese los valores del array:\n");
    for (int i = 0; i < n; i++) {
        printf("Elemento [%d]: ", i);
        scanf("%d", &array[i]);
    }
    
    // Imprimir el array
    printf("\nArray ingresado:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
    
    // Liberar la memoria asignada
    free(array);
    
    return 0;
}
