//Parte 1

#include <stdio.h>
#include <stdlib.h>

// Función que cuenta el número de vocales en una palabra (solo minúsculas)
int contar_vocales(char *palabra) {
    int contador = 0;
    for (int i = 0; palabra[i] != '\0'; i++) {
        // Solo se cuentan las vocales en minúscula
        if (palabra[i] == 'a' || palabra[i] == 'e' ||
            palabra[i] == 'i' || palabra[i] == 'o' ||
            palabra[i] == 'u') {
            contador++;
        }
    }
    return contador;
}

int main() {
    int tamano;

    // 1. Solicitar el tamaño de la palabra (número entero positivo)
    printf("Ingrese el tamaño de la palabra: ");
    if (scanf("%d", &tamano) != 1 || tamano <= 0) {
        printf("Error: Debe ingresar un número entero positivo.\n");
        return 1;
    }

    // 2. Reservar memoria dinámicamente para la palabra (+1 para el carácter nulo)
    char *palabra = (char *)malloc((tamano + 1) * sizeof(char));
    if (palabra == NULL) {
        printf("Error al reservar memoria.\n");
        return 1;
    }

    // Limpiar el buffer de entrada
    while (getchar() != '\n');

    // 3. Solicitar al usuario que introduzca la palabra
    printf("Ingrese la palabra (en minúsculas): ");
    if (fgets(palabra, tamano + 1, stdin) == NULL) {
        printf("Error al leer la palabra.\n");
        free(palabra);
        return 1;
    }

    // Eliminar el salto de línea, si está presente
    for (int i = 0; palabra[i] != '\0'; i++) {
        if (palabra[i] == '\n') {
            palabra[i] = '\0';
            break;
        }
    }

    // 4. Llamar a la función contar_vocales y mostrar el resultado
    int num_vocales = contar_vocales(palabra);
    printf("La palabra \"%s\" tiene %d vocales.\n", palabra, num_vocales);

    // 5. Liberar la memoria utilizada
    free(palabra);

    return 0;
}


#include <stdio.h>
#include <stdlib.h>

// Función que intercambia la primera y la última fila de la matriz
void intercambiarFilas(int **matriz, int n) {
    int temp;
    // Recorremos cada columna de la primera y la última fila para intercambiar sus elementos
    for (int j = 0; j < n; j++) {
        temp = matriz[0][j];
        matriz[0][j] = matriz[n - 1][j];
        matriz[n - 1][j] = temp;
    }
}

int main() {
    int n;

    // 1. Solicitar un número entero positivo n
    printf("Ingrese el tamaño (n) de la matriz cuadrada: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: debe ingresar un número entero positivo.\n");
        return 1;
    }

    // 2. Reservar memoria dinámicamente para una matriz cuadrada de n x n enteros
    int **matriz = (int **)malloc(n * sizeof(int *));
    if (matriz == NULL) {
        printf("Error al reservar memoria para las filas.\n");
        return 1;
    }
    for (int i = 0; i < n; i++) {
        matriz[i] = (int *)malloc(n * sizeof(int));
        if (matriz[i] == NULL) {
            printf("Error al reservar memoria para la fila %d.\n", i);
            // Liberamos la memoria ya reservada en caso de error
            for (int j = 0; j < i; j++) {
                free(matriz[j]);
            }
            free(matriz);
            return 1;
        }
    }

    // 3. Rellenar la matriz con valores ingresados por el usuario
    printf("Ingrese los elementos de la matriz (%d x %d):\n", n, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("Elemento [%d][%d]: ", i, j);
            if (scanf("%d", &matriz[i][j]) != 1) {
                printf("Error en la entrada de datos.\n");
                // Liberar memoria en caso de error
                for (int k = 0; k < n; k++) {
                    free(matriz[k]);
                }
                free(matriz);
                return 1;
            }
        }
    }

    // Mostrar la matriz original
    printf("\nMatriz original:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }

    // 4. Intercambiar la primera y la última fila de la matriz
    intercambiarFilas(matriz, n);

    // Mostrar la matriz modificada
    printf("\nMatriz después de intercambiar la primera y la última fila:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }

    // 5. Liberar la memoria utilizada
    for (int i = 0; i < n; i++) {
        free(matriz[i]);
    }
    free(matriz);

    return 0;
}












/*Escriba un programa en C que realice las siguientes acciones:

1. Solicite un número entero positivo que representará el tamaño de un array de caracteres (una palabra).
2. Reserve memoria dinámicamente para la palabra.
3. Solicite al usuario que introduzca la palabra.
4. Implemente una función `int contar_vocales(char *palabra)` que devuelva el número de vocales en la palabra.
5. Libere la memoria utilizada correctamente.*/



//Parte 2
/*Escriba un programa en C que realice las siguientes acciones:

1. Solicite un número entero positivo `n`.
2. Reserve memoria dinámicamente para una matriz cuadrada de `n × n` enteros.
3. Rellene la matriz con valores ingresados por el usuario.
4. Implemente una función que intercambie la primera y la última fila de la matriz.
5. Libere la memoria correctamente.*/