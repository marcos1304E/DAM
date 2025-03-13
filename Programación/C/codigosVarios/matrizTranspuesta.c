#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, m;
    
    // ----------------------------------------------------------------------
    // 1. Solicitar las dimensiones de la matriz (n filas y m columnas)
    // ----------------------------------------------------------------------
    printf("Ingrese el número de filas (n): ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: debe ingresar un número entero positivo para n.\n");
        return 1;
    }
    
    printf("Ingrese el número de columnas (m): ");
    if (scanf("%d", &m) != 1 || m <= 0) {
        printf("Error: debe ingresar un número entero positivo para m.\n");
        return 1;
    }
    
    // ----------------------------------------------------------------------
    // 2. Reserva de memoria dinámica para la matriz original (n x m)
    // ----------------------------------------------------------------------
    int **matriz = (int **)malloc(n * sizeof(int *));
    if (matriz == NULL) {
        printf("Error al reservar memoria para las filas de la matriz.\n");
        return 1;
    }
    for (int i = 0; i < n; i++) {
        matriz[i] = (int *)malloc(m * sizeof(int));
        if (matriz[i] == NULL) {
            printf("Error al reservar memoria para la fila %d de la matriz.\n", i);
            // Liberar las filas ya reservadas
            for (int j = 0; j < i; j++) {
                free(matriz[j]);
            }
            free(matriz);
            return 1;
        }
    }
    
    // ----------------------------------------------------------------------
    // 3. Rellenar la matriz con valores ingresados por el usuario
    // ----------------------------------------------------------------------
    printf("\nIngrese los elementos de la matriz (%d x %d):\n", n, m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Elemento [%d][%d]: ", i, j);
            if (scanf("%d", &matriz[i][j]) != 1) {
                printf("Error en la entrada de datos.\n");
                // Liberar la memoria reservada
                for (int k = 0; k < n; k++) {
                    free(matriz[k]);
                }
                free(matriz);
                return 1;
            }
        }
    }
    
    // ----------------------------------------------------------------------
    // 4. Reserva de memoria dinámica para la matriz transpuesta (m x n)
    // ----------------------------------------------------------------------
    int **transpuesta = (int **)malloc(m * sizeof(int *));
    if (transpuesta == NULL) {
        printf("Error al reservar memoria para las filas de la transpuesta.\n");
        // Liberar la matriz original
        for (int i = 0; i < n; i++) {
            free(matriz[i]);
        }
        free(matriz);
        return 1;
    }
    for (int i = 0; i < m; i++) {
        transpuesta[i] = (int *)malloc(n * sizeof(int));
        if (transpuesta[i] == NULL) {
            printf("Error al reservar memoria para la fila %d de la transpuesta.\n", i);
            // Liberar las filas ya reservadas para la transpuesta y la matriz original
            for (int j = 0; j < i; j++) {
                free(transpuesta[j]);
            }
            free(transpuesta);
            for (int k = 0; k < n; k++) {
                free(matriz[k]);
            }
            free(matriz);
            return 1;
        }
    }
    
    // ----------------------------------------------------------------------
    // 5. Calcular la matriz transpuesta
    // La transpuesta se obtiene intercambiando filas por columnas:
    // transpuesta[j][i] = matriz[i][j]
    // ----------------------------------------------------------------------
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            transpuesta[j][i] = matriz[i][j];
        }
    }
    
    // ----------------------------------------------------------------------
    // 6. Mostrar la matriz original
    // ----------------------------------------------------------------------
    printf("\nMatriz original (%d x %d):\n", n, m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
    
    // ----------------------------------------------------------------------
    // Mostrar la matriz transpuesta
    // ----------------------------------------------------------------------
    printf("\nMatriz transpuesta (%d x %d):\n", m, n);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", transpuesta[i][j]);
        }
        printf("\n");
    }
    
    // ----------------------------------------------------------------------
    // 7. Liberar la memoria utilizada
    // ----------------------------------------------------------------------
    for (int i = 0; i < n; i++) {
        free(matriz[i]);
    }
    free(matriz);
    
    for (int i = 0; i < m; i++) {
        free(transpuesta[i]);
    }
    free(transpuesta);
    
    return 0;
}
