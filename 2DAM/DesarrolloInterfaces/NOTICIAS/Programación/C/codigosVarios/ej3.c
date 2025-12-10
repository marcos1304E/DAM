#include <stdio.h>
#include <stdlib.h>

// Función para inicializar un array con múltiplos de un número dado
void inicializarArray(int *array, int n, int multiplo) {
    for (int i = 0; i < n; i++) {
        array[i] = multiplo * (i + 1);
    }
}

// Función para imprimir un array
void imprimirArray(int *array, int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

int main() {
    int n;
    
    // Solicitar tamaño del array
    printf("Ingrese el tamaño del array: ");
    scanf("%d", &n);
    if (n <= 0) {
        printf("El tamaño debe ser un número entero positivo.\n");
        return 1;
    }
    
    // Crear e inicializar el primer array
    int *array1 = (int *)malloc(n * sizeof(int));
    int multiplo1;
    printf("Ingrese el número base para los múltiplos del primer array: ");
    scanf("%d", &multiplo1);
    inicializarArray(array1, n, multiplo1);
    
    // Crear e inicializar el segundo array
    int *array2 = (int *)malloc(n * sizeof(int));
    int multiplo2;
    printf("Ingrese el número base para los múltiplos del segundo array: ");
    scanf("%d", &multiplo2);
    inicializarArray(array2, n, multiplo2);
    
    // Mostrar los arrays generados
    printf("Primer array: ");
    imprimirArray(array1, n);
    printf("Segundo array: ");
    imprimirArray(array2, n);
    
    // Preguntar al usuario la operación deseada
    int opcion;
    printf("Seleccione una opción: 1 - Suma coordenada a coordenada, 2 - Concatenar: ");
    scanf("%d", &opcion);
    
    if (opcion == 1) {
        // Sumar coordenada a coordenada
        int *sumaArray = (int *)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++) {
            sumaArray[i] = array1[i] + array2[i];
        }
        printf("Resultado de la suma: ");
        imprimirArray(sumaArray, n);
        free(sumaArray);
    } else if (opcion == 2) {
        // Concatenar arrays
        int *concatArray = (int *)malloc(2 * n * sizeof(int));
        for (int i = 0; i < n; i++) {
            concatArray[i] = array1[i];
            concatArray[i + n] = array2[i];
        }
        printf("Resultado de la concatenación: ");
        imprimirArray(concatArray, 2 * n);
        free(concatArray);
    } else {
        printf("Opción no válida.\n");
    }
    
    // Liberar memoria
    free(array1);
    free(array2);
    
    return 0;
}
