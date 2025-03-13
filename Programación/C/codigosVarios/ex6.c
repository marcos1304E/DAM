//Parte 1(solo esto)

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n, m;

    // Solicitar dos números enteros positivos n y m
    printf("Introduce el número de filas (n): ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debes ingresar un número entero positivo para las filas.\n");
        return 1;
    }

    printf("Introduce el número de columnas (m): ");
    if (scanf("%d", &m) != 1 || m <= 0) {
        printf("Error: Debes ingresar un número entero positivo para las columnas.\n");
        return 1;
    }

    // 2. Reservar memoria dinámica para la matriz de n x m elementos
    int **matriz = malloc(n * sizeof(int*));
    if (matriz == NULL) {
        printf("Error al reservar memoria para la matriz.\n");
        return 1;
    }

    for (int i = 0; i < n; i++) {
        matriz[i] = malloc(m * sizeof(int));
        if (matriz[i] == NULL) {
            printf("Error al reservar memoria para la fila %d de la matriz.\n", i);
            return 1;
        }
    }

    // 3. Inicializar la matriz, donde cada posición es la suma de la fila y la columna
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            matriz[i][j] = i + j;
        }
    }

    // 4. Calcular la suma de los elementos de cada fila y almacenarlos en un array dinámico
    int *sumas_filas = malloc(n * sizeof(int));
    if (sumas_filas == NULL) {
        printf("Error al reservar memoria para el array de sumas por filas.\n");
        return 1;
    }

    for (int i = 0; i < n; i++) {
        sumas_filas[i] = 0;
        for (int j = 0; j < m; j++) {
            sumas_filas[i] += matriz[i][j];
        }
    }

    // 5. Imprimir la matriz y el array con las sumas por filas
    printf("\nMatriz:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }

    printf("\nSuma de los elementos por fila:\n");
    for (int i = 0; i < n; i++) {
        printf("Suma de la fila %d: %d\n", i, sumas_filas[i]);
    }

    // Liberar la memoria utilizada
    for (int i = 0; i < n; i++) {
        free(matriz[i]);
    }
    free(matriz);
    free(sumas_filas);

    return 0;
}



/*Implemente un programa en C que realice las siguientes tareas:

1. Solicite al usuario dos números enteros positivos n y m.
2. Reserve memoria dinámicamente para una matriz de n × m elementos de tipo int.
3. Inicialice la matriz. Cada posición deberá ser la suma de la fila y la columna en la que se encuentre.
4. Calcule la suma de los elementos de cada fila y la almacene en un array dinámico. diferente.
5. Imprima la matriz y el array con las sumas por filas.*/