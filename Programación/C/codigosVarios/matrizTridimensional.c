#include <stdio.h>
#include <stdlib.h>

int main() {
    int x, y, z;

    // Pidiendo dimensiones de la matriz
    printf("Ingrese las dimensiones de la matriz tridimensional (x, y, z): ");
    scanf("%d %d %d", &x, &y, &z);

    // Creación de la matriz tridimensional utilizando memoria dinámica
    int ***matriz = (int ***)malloc(x * sizeof(int **)); // Reservar espacio para 'x' filas

    for (int i = 0; i < x; i++) {
        matriz[i] = (int **)malloc(y * sizeof(int *)); // Reservar espacio para 'y' columnas en cada fila

        for (int j = 0; j < y; j++) {
            matriz[i][j] = (int *)malloc(z * sizeof(int)); // Reservar espacio para 'z' elementos en cada columna
        }
    }

    // Inicialización de la matriz con valores
    printf("Ingrese los valores para la matriz tridimensional:\n");
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            for (int k = 0; k < z; k++) {
                printf("Elemento [%d][%d][%d]: ", i, j, k);
                scanf("%d", &matriz[i][j][k]);
            }
        }
    }

    // Mostrando la matriz
    printf("\nMatriz tridimensional ingresada:\n");
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            for (int k = 0; k < z; k++) {
                printf("Elemento [%d][%d][%d] = %d\n", i, j, k, matriz[i][j][k]);
            }
        }
    }

    // Liberación de la memoria dinámica
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            free(matriz[i][j]); // Liberar cada "capa"
        }
        free(matriz[i]); // Liberar las columnas
    }
    free(matriz); // Liberar las filas

    return 0;
}
