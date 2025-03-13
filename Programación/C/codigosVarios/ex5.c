/*Parte 1(escrita)*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definir la función para invertir la palabra
char* invertir(char *palabra) {
    // Obtener la longitud de la palabra
    int len = strlen(palabra);
    
    // Reservar memoria para la palabra invertida
    char *invertida = malloc((len + 1) * sizeof(char));  // +1 para el carácter '\0'
    
    if (invertida == NULL) {
        printf("Error al reservar memoria.\n");
        exit(1);
    }
    
    // Llenar el array invertido con los caracteres en orden inverso
    for (int i = 0; i < len; i++) {
        invertida[i] = palabra[len - 1 - i];
    }
    
    invertida[len] = '\0';  // Asegurarse de que el string termina con '\0'
    
    // Imprimir la palabra invertida
    printf("Palabra invertida: %s\n", invertida);
    
    // Devolver el puntero a la palabra invertida
    return invertida;
}

int main(void) {
    int n;
    
    // Solicitar el tamaño del array
    printf("Introduce un número entero positivo para el tamaño de la palabra: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debes ingresar un número entero positivo.\n");
        return 1;
    }
    
    // Reservar memoria dinámica para el array de caracteres
    char *palabra = malloc((n + 1) * sizeof(char));  // +1 para el carácter '\0'
    
    if (palabra == NULL) {
        printf("Error al reservar memoria.\n");
        return 1;
    }
    
    // Solicitar la palabra al usuario
    printf("Introduce una palabra: ");
    scanf("%s", palabra);
    
    // Llamar a la función para invertir la palabra
    char *invertida = invertir(palabra);
    
    // Imprimir la palabra original
    printf("Palabra original: %s\n", palabra);
    
    // Liberar la memoria reservada
    free(palabra);
    free(invertida);
    
    return 0;
}


#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n;

    // Solicitar al usuario un número entero positivo
    printf("Introduce un número entero positivo para el tamaño del array: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debes ingresar un número entero positivo.\n");
        return 1;
    }

    // Reservar memoria dinámicamente para el array de tipo double
    double *array = malloc(n * sizeof(double));
    if (array == NULL) {
        printf("Error al reservar memoria.\n");
        return 1;
    }

    // Inicializar el array con los valores de la fórmula: valor[i] = 1/(i+1)
    for (int i = 0; i < n; i++) {
        array[i] = 1.0 / (i + 1);
    }

    // Imprimir el contenido del array
    printf("\nContenido del array:\n");
    for (int i = 0; i < n; i++) {
        printf("array[%d] = %.6f\n", i, array[i]);
    }

    // Liberar la memoria utilizada
    free(array);

    return 0;
}



//Parte 1
/*1. Escriba un programa en C que realice las siguientes acciones:
    - Defina una función `char* invertir(char *palabra)` que:
        - Imprima en orden inverso los caracteres en la palabra recibida como argumento
        - Guarde en un array nuevo la palabra invertida.
        - La función debe devolver el puntero donde se encuentra la palabra invertida.
    - En el main:
        - Solicite un número entero positivo que determinará el tamaño de un array de caracteres (para almacenar una palabra).
        - Reserve memoria dinámicamente para la palabra.
        - Solicite al usuario que introduzca una palabra.
        - Llama a la función invertir
    - Imprima la palabra inicial*/


//Parte 2
/*Implemente un programa en C que realice las siguientes tareas:

1. Solicite al usuario un número entero positivo que determinará el tamaño de un array de `double`.
2. Reserve dinámicamente memoria para el array.
3. Inicialice el array con valores que sigan la siguiente fórmula:
valor[i]= 1/(i+1)
4. Imprima en pantalla el contenido del array.*/