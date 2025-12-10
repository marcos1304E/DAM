#include <stdio.h>
#include <stdlib.h>

// Función para intercambiar la primera y la última fila de la matriz
void intercambiarFilas(int **matriz, int n) {
    if (n > 1) {
        for (int i = 0; i < n; i++) {
            int temp = matriz[0][i];
            matriz[0][i] = matriz[n-1][i];
            matriz[n-1][i] = temp;
        }
    }
}

int main() {
    int n;
    
    // Solicitar al usuario un número entero positivo
    printf("Ingrese el tamaño de la matriz cuadrada (n): ");
    scanf("%d", &n);
    
    if (n <= 0) {
        printf("El tamaño de la matriz debe ser un entero positivo.\n");
        return 1;
    }
    
    // Reservar memoria para la matriz
    int **matriz = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++) {
        matriz[i] = (int *)malloc(n * sizeof(int));
    }
    
    // Rellenar la matriz con valores ingresados por el usuario
    printf("Ingrese los elementos de la matriz (%d x %d):\n", n, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &matriz[i][j]);
        }
    }
    
    // Mostrar la matriz original
    printf("Matriz original:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
    
    // Intercambiar la primera y la última fila
    intercambiarFilas(matriz, n);
    
    // Mostrar la matriz después del intercambio
    printf("\nMatriz después de intercambiar la primera y última fila:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
    
    // Liberar la memoria asignada dinámicamente
    for (int i = 0; i < n; i++) {
        free(matriz[i]);
    }
    free(matriz);
    
    return 0;
}
