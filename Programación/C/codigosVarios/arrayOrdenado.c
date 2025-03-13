#include <stdio.h>
#include <stdlib.h>

void ordenar(int *array, int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}

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
    
    // Ordenar el array
    ordenar(array, n);
    
    // Imprimir el array ordenado
    printf("\nArray ordenado:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
    
    // Liberar la memoria asignada
    free(array);
    
    return 0;
}
