#include <stdio.h>
#include <stdlib.h>

// ======================================================================
// Aquí puedes declarar funciones adicionales que te soliciten en el examen.
// Ejemplo de función (descomentar y modificar según lo requerido):
//
// // Función de ejemplo: contar la cantidad de elementos pares en un arreglo
// int contarPares(int *array, int n) {
//     int contador = 0;
//     for (int i = 0; i < n; i++) {
//         if (array[i] % 2 == 0) {
//             contador++;
//         }
//     }
//     return contador;
// }
//
// Otra función: intercambiar la primera y la última fila de una matriz, etc.
// ======================================================================

int main() {
    // ----------------------------------------------------------------------
    // 1. Solicitar un número entero positivo
    // ----------------------------------------------------------------------
    int n;
    printf("Ingrese un número entero positivo: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: debe ingresar un número entero positivo.\n");
        return 1;
    }

    // ----------------------------------------------------------------------
    // 2. Reserva de memoria dinámica
    // Ejemplo A: Reserva para un arreglo de enteros
    // ----------------------------------------------------------------------
    int *array = (int *)malloc(n * sizeof(int));
    if (array == NULL) {
        printf("Error al reservar memoria para el arreglo.\n");
        return 1;
    }
    
    // ----------------------------------------------------------------------
    // Ejemplo B: Reserva para una matriz cuadrada de n x n enteros
    // (Descomentar si se requiere trabajar con matrices)
    // ----------------------------------------------------------------------
    /*
    int **matriz = (int **)malloc(n * sizeof(int *));
    if (matriz == NULL) {
        printf("Error al reservar memoria para las filas de la matriz.\n");
        free(array);  // En caso de haber reservado otros recursos
        return 1;
    }
    for (int i = 0; i < n; i++) {
        matriz[i] = (int *)malloc(n * sizeof(int));
        if (matriz[i] == NULL) {
            printf("Error al reservar memoria para la fila %d de la matriz.\n", i);
            // Liberar la memoria ya asignada antes de terminar
            for (int j = 0; j < i; j++) {
                free(matriz[j]);
            }
            free(matriz);
            free(array);
            return 1;
        }
    }
    */

    // ----------------------------------------------------------------------
    // 3. Rellenar la estructura (arreglo o matriz) con valores ingresados por el usuario
    // ----------------------------------------------------------------------
    // Ejemplo para arreglo:
    printf("\nIngrese %d valores enteros para el arreglo:\n", n);
    for (int i = 0; i < n; i++) {
        printf("Valor %d: ", i + 1);
        if (scanf("%d", &array[i]) != 1) {
            printf("Error en la entrada de datos.\n");
            free(array);
            // Si se reservó la matriz, liberar también su memoria
            return 1;
        }
    }

    // ----------------------------------------------------------------------
    // Ejemplo para matriz (descomentar si se trabaja con matrices)
    // ----------------------------------------------------------------------
    /*
    printf("\nIngrese los elementos de la matriz (%d x %d):\n", n, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("Elemento [%d][%d]: ", i, j);
            if (scanf("%d", &matriz[i][j]) != 1) {
                printf("Error en la entrada de datos.\n");
                // Liberar la memoria antes de terminar
                for (int k = 0; k < n; k++) {
                    free(matriz[k]);
                }
                free(matriz);
                free(array);
                return 1;
            }
        }
    }
    */

    // ----------------------------------------------------------------------
    // 4. Llamar a funciones o insertar el código que procese la estructura.
    // Aquí se colocan las llamadas a funciones, por ejemplo:
    // - Contar vocales en una palabra.
    // - Intercambiar filas en una matriz.
    // - Ordenar un arreglo.
    //
    // Ejemplo (para arreglo): contar números pares
    // int pares = contarPares(array, n);
    // printf("El arreglo tiene %d números pares.\n", pares);
    //
    // Ejemplo (para matriz): intercambiar la primera y la última fila
    // intercambiarFilas(matriz, n);
    // ----------------------------------------------------------------------
    
    // Ejemplo: Mostrar el arreglo
    printf("\nElementos ingresados en el arreglo:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    // ----------------------------------------------------------------------
    // 5. Liberar la memoria utilizada
    // ----------------------------------------------------------------------
    free(array);
    
    // Si se reservó la matriz, liberar cada fila y luego la matriz:
    /*
    for (int i = 0; i < n; i++) {
        free(matriz[i]);
    }
    free(matriz);
    */
    
    return 0;
}