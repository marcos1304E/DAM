#include <stdio.h>
#include <stdlib.h>

int main() {
    int filas, columnas;
    
    // Pedir tamaño de la matriz
    printf("Ingrese el número de filas: ");
    scanf("%d", &filas);
    printf("Ingrese el número de columnas: ");
    scanf("%d", &columnas);
    
    // Reservar memoria para la matriz
    int **matriz = (int **)malloc(filas * sizeof(int *));
    if (matriz == NULL) {
        printf("Error al asignar memoria\n");
        return 1;
    }
    for (int i = 0; i < filas; i++) {
        matriz[i] = (int *)malloc(columnas * sizeof(int));
        if (matriz[i] == NULL) {
            printf("Error al asignar memoria\n");
            return 1;
        }
    }
    
    // Llenar la matriz con valores
    printf("Ingrese los valores de la matriz:\n");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("Elemento [%d][%d]: ", i, j);
            scanf("%d", &matriz[i][j]);
        }
    }
    
    // Imprimir la matriz
    printf("\nMatriz ingresada:\n");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
    
    // Liberar la memoria asignada
    for (int i = 0; i < filas; i++) {
        free(matriz[i]);
    }
    free(matriz);
    
    return 0;
}