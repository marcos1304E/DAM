/*ejercicio 1*/

#include <stdio.h>
#include <stdlib.h>

// Función que recibe un carácter en minúscula y lo transforma a mayúscula.
// En esta versión se devuelve el carácter modificado, de modo que el main puede
// asignarlo de nuevo en la posición correspondiente del arreglo.
char capitalizar(char letra_minuscula) {
    letra_minuscula = letra_minuscula + 'Z' - 'z';
    // Se puede imprimir la letra en mayúscula si se desea:
    printf("%c", letra_minuscula);
    return letra_minuscula;
}

int main(void) {
    int tam;
    
    // Pedir el tamaño de la palabra
    printf("Introduce el tamaño de la palabra: ");
    scanf("%d", &tam);
    
    // Reservar dinámicamente espacio para la palabra (se reserva tam+1 para el '\0')
    char *palabra = malloc((tam + 1) * sizeof(char));
    if (palabra == NULL) {
        printf("Error en la asignación de memoria.\n");
        return 1;
    }
    
    // Leer la palabra (se asume que el usuario introduce exactamente tam caracteres)
    printf("Introduce una palabra de longitud %d: ", tam);
    scanf("%s", palabra);
    
    // Llamar a la función capitalizar para cada uno de los caracteres y actualizar la palabra.
    for (int i = 0; i < tam; i++) {
        palabra[i] = capitalizar(palabra[i]);
    }
    
    // Imprimir la palabra modificada
    printf("\nPalabra capitalizada: %s\n", palabra);
    
    free(palabra);
    return 0;
}
 
/*ejercicio 2 abajo*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int size1, size2;
    
    // 1. Solicitar al usuario el tamaño del primer array
    printf("Introduce el tamaño del primer array (entero positivo): ");
    if (scanf("%d", &size1) != 1 || size1 <= 0) {
        printf("Error: Debe introducir un entero positivo.\n");
        return 1;
    }
    
    // 2. Crear el primer array y rellenarlo con múltiplos de 3
    int *array1 = malloc(size1 * sizeof(int));
    if (array1 == NULL) {
        printf("Error en la asignación de memoria para el primer array.\n");
        return 1;
    }
    for (int i = 0; i < size1; i++) {
        array1[i] = (i + 1) * 3; // Por ejemplo: 3, 6, 9, ...
    }
    
    // 3. Repetir el proceso para el segundo array (tamaño y relleno con múltiplos de 5)
    printf("Introduce el tamaño del segundo array (entero positivo): ");
    if (scanf("%d", &size2) != 1 || size2 <= 0) {
        printf("Error: Debe introducir un entero positivo.\n");
        free(array1);
        return 1;
    }
    
    int *array2 = malloc(size2 * sizeof(int));
    if (array2 == NULL) {
        printf("Error en la asignación de memoria para el segundo array.\n");
        free(array1);
        return 1;
    }
    for (int i = 0; i < size2; i++) {
        array2[i] = (i + 1) * 5; // Por ejemplo: 5, 10, 15, ...
    }
    
    // 4. Preguntar al usuario si quiere concatenar o sumar coordenada a coordenada
    char opcion;
    printf("Elige la operación a realizar:\n");
    printf("  S - Sumar coordenada a coordenada\n");
    printf("  C - Concatenar los arrays\n");
    printf("Introduce tu opción (S/C): ");
    scanf(" %c", &opcion);
    
    int *resultado = NULL; // Array resultante
    int size_result = 0;
    
    if (opcion == 'S' || opcion == 's') {
        // Para sumar coordenada a coordenada, los arrays deben tener el mismo tamaño
        if (size1 != size2) {
            printf("Error: Para sumar coordenada a coordenada, ambos arrays deben tener el mismo tamaño.\n");
            free(array1);
            free(array2);
            return 1;
        }
        size_result = size1; // O size2, ya que son iguales
        resultado = malloc(size_result * sizeof(int));
        if (resultado == NULL) {
            printf("Error en la asignación de memoria para el array resultado.\n");
            free(array1);
            free(array2);
            return 1;
        }
        for (int i = 0; i < size_result; i++) {
            resultado[i] = array1[i] + array2[i];
        }
    }
    else if (opcion == 'C' || opcion == 'c') {
        // Concatenar: el tamaño del array resultado es la suma de los dos tamaños
        size_result = size1 + size2;
        resultado = malloc(size_result * sizeof(int));
        if (resultado == NULL) {
            printf("Error en la asignación de memoria para el array resultado.\n");
            free(array1);
            free(array2);
            return 1;
        }
        // Copiar el primer array
        for (int i = 0; i < size1; i++) {
            resultado[i] = array1[i];
        }
        // Copiar el segundo array
        for (int i = 0; i < size2; i++) {
            resultado[size1 + i] = array2[i];
        }
    }
    else {
        printf("Opción no válida.\n");
        free(array1);
        free(array2);
        return 1;
    }
    
    // 5. Imprimir en pantalla el array resultado
    printf("\nArray resultado:\n");
    for (int i = 0; i < size_result; i++) {
        printf("%d ", resultado[i]);
    }
    printf("\n");
    
    // 6. Liberar memoria y terminar
    free(array1);
    free(array2);
    free(resultado);
    
    return 0;
}










/*1. Escriba un programa en C que realice las siguientes acciones (3p.) arriba
    1. Pedir un entero que determinará el tamaño de la palabra.
    2. Reservar dinámicamente espacio para una palabra de esa longitud.
    3. Leer por pantalla una palabra de esa longitud. [Es responsabilidad del usuario introducir una palabra de la longitud exacta que ha introducido anteriormente. No es necesario controlar erorres de este tipo]
    4. Llamar a la función `capitalizar` para cada uno de los caracteres. (Función implementada más abajo)
    5. Imprimir la palabra. 

**Pregunta 1 (1p.) :** ¿Los cambios que realiza la función capitalizar son persistentes al terminar la función? Es decir, ¿la palabra introducida por el usuario ha sido modificada en memoria o no? En caso de responder negativamente, modifica la función para que los cambios que realiza sean persistentes en el main. En caso de responder afirmativamente, realiza un diagrama de memoria en el que expliques cómo ocurre esa modificación.

No, los cambios no son persistentes si la función se usa de forma aislada, ya que en C los argumentos se pasan por valor. Esto significa que al llamar a capitalizar, se pasa una copia del carácter y la modificación afecta solo a esa copia.

Modificar la función para que trabaje por referencia, es decir, que reciba un puntero a carácter y modifique directamente la memoria. Por ejemplo:

void capitalizar(char *letra_minuscula) {
    *letra_minuscula = *letra_minuscula + 'Z' - 'z';
    printf("%c", *letra_minuscula);
}

Y en el main se llamaría:

capitalizar(&palabra[i]);

Diagrama de memoria (usando la solución asignando el resultado):

Supongamos que el usuario introduce el tamaño 4 y la palabra "hola". La memoria quedaría de la siguiente manera:

[ Palabra ]
+---------+---------+---------+---------+----------+
|  'h'    |  'o'    |  'l'    |  'a'    |  '\0'    |
+---------+---------+---------+---------+----------+
   ^         ^         ^         ^
   |         |         |         |
   |         |         |         └---> Posición 3 (actualizada a 'A' tras llamar a capitalizar)
   |         |         └--------------> Posición 2 (actualizada a 'L')
   |         └-------------------------> Posición 1 (actualizada a 'O')
   └-------------------------------------> Posición 0 (actualizada a 'H')

En main, se llama capitalizar(palabra[0]) con el valor 'h'. La función calcula la mayúscula 'H' y la devuelve. Luego se asigna a palabra[0].
Lo mismo ocurre para las posiciones 1, 2 y 3. Así, los cambios son persistentes en la variable palabra.



**Pregunta 2 (1p.):** ¿Qué ocurre si se introduce una palabra de más longitud de la reservada? Por ejemplo, qué ocurriría si se reserva memoria para una palabra de longitud 5 y se introduce por pantalla “murciélago”. ¿Podría imprimirse la palabra? ¿Se imprimiría correctamente? ¿Por qué?

Si se reserva memoria para una palabra de longitud 5 (o sea, 6 caracteres contando el '\0') y se introduce una palabra mayor, se producirá un desbordamiento de búfer (buffer overflow). Esto significa que:

Podría imprimirse la palabra:
Es posible que parte de la palabra o incluso la palabra completa se imprima, pero esto depende de cómo se gestione la memoria en tiempo de ejecución.
¿Se imprimiría correctamente?:
No. El comportamiento es indefinido. El desbordamiento podría sobrescribir otras áreas de la memoria, provocar errores o incluso una violación de acceso que termine el programa de forma inesperada.
¿Por qué?:
Porque al introducir más caracteres que los reservados, se está escribiendo en memoria que no se ha asignado para la variable palabra, lo que puede corromper datos o provocar fallos en el programa.



*/
/*Parte 2*/
/*1. Solicite al usuario un número entero positivo que determinará el tamaño de un array de números de enteros.
2. Cree un array de enteros con el tamaño especificado y rellénalo con múltiplos de un número a tu elección.
3. Repetir el proceso para un segundo array diferente.
4. Preguntar al usuario si quiere concatenar o sumar coordenada a coordenada.
    1. En caso de sumar coordenada a coordenada, el programa deberá crear un array nuevo del tamaño necesario en el que almacenar la suma posición a posición de los 2 arrays.
    2. En caso de querer concatenar, el programa deberá crear un array nuevo del tamaño necesario para rellenarlo, primero con un array y después con el otro. 
5. Imprima en pantalla el resultado.
6. Terminar.
*/