#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    
    // Solicitar al usuario un número entero positivo
    printf("Ingrese el tamaño del array: ");
    scanf("%d", &n);
    
    if (n <= 0) {
        printf("El tamaño del array debe ser un entero positivo.\n");
        return 1;
    }
    
    // Reservar memoria para el array
    double *array = (double *)malloc(n * sizeof(double));
    if (array == NULL) {
        printf("Error al asignar memoria.\n");
        return 1;
    }
    
    // Inicializar el array con la fórmula valor[i] = 1/(i+1)
    for (int i = 0; i < n; i++) {
        array[i] = 1.0 / (i + 1);
    }
    
    // Imprimir el contenido del array
    printf("Contenido del array:\n");
    for (int i = 0; i < n; i++) {
        printf("%.6f ", array[i]);
    }
    printf("\n");
    
    // Liberar la memoria asignada dinámicamente
    free(array);
    
    return 0;
}
