/*Parte 1(papel)*/
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n;

    // Solicitar al usuario el tamaño del array (entero positivo)
    printf("Introduce un número entero positivo para determinar el tamaño del array: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debe ingresar un entero positivo.\n");
        return 1;
    }

    // Reservar memoria dinámicamente para un array de enteros de tamaño n
    int *array = malloc(n * sizeof(int));
    if (array == NULL) {
        printf("Error en la asignación de memoria.\n");
        return 1;
    }

    // Solicitar al usuario que ingrese los valores para llenar el array
    printf("Introduce %d valores enteros:\n", n);
    for (int i = 0; i < n; i++) {
        printf("Valor para array[%d]: ", i);
        if (scanf("%d", &array[i]) != 1) {
            printf("Error en la lectura del valor.\n");
            free(array);  // Liberar memoria antes de terminar
            return 1;
        }
    }

    // Mostrar el contenido del array (opcional)
    printf("\nContenido del array:\n");
    for (int i = 0; i < n; i++) {
        printf("array[%d] = %d\n", i, array[i]);
    }

    // Liberar la memoria utilizada
    free(array);

    return 0;
}

/*Parte 2*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n, new_size;
    double *array;

    // 1. Solicitar un número entero positivo
    printf("Introduce un número entero positivo para el tamaño del array: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debes introducir un entero positivo.\n");
        return 1;
    }

    // 2. Reservar dinámicamente memoria para el array de double
    array = malloc(n * sizeof(double));
    if (array == NULL) {
        printf("Error en la asignación de memoria.\n");
        return 1;
    }

    // 3. Inicializar el array con la fórmula: valor[i] = 1/(i+1)
    for (int i = 0; i < n; i++) {
        array[i] = 1.0 / (i + 1);
    }

    // 4. Imprimir en pantalla el contenido del array original
    printf("\nContenido del array original:\n");
    for (int i = 0; i < n; i++) {
        printf("array[%d] = %lf\n", i, array[i]);
    }

    // 5. Aumentar el tamaño del array al doble de su tamaño original
    new_size = n * 2;
    double *temp = realloc(array, new_size * sizeof(double));
    if (temp == NULL) {
        printf("Error en la realocación de memoria.\n");
        free(array);
        return 1;
    }
    array = temp;

    // Completar los nuevos valores con la misma fórmula
    for (int i = n; i < new_size; i++) {
        array[i] = 1.0 / (i + 1);
    }

    // 6. Imprimir en pantalla el contenido del array después de la expansión
    printf("\nContenido del array después de la expansión:\n");
    for (int i = 0; i < new_size; i++) {
        printf("array[%d] = %lf\n", i, array[i]);
    }

    // 7. Liberar la memoria utilizada
    free(array);

    return 0;
}

/*### **Parte 1: Ejercicio en papel (Tiempo estimado: ¿20 minutos?) (3 p.)**

1. Escriba un programa en C que realice las siguientes acciones:
    - Solicite al usuario un número entero positivo, que determinará el tamaño de un array de enteros.
    - Reserve memoria dinámicamente para el array.
    - Solicite al usuario que ingrese los valores para llenar el array.
    - Libere la memoria utilizada correctamente.

**Nota:** Se valorará la correcta reserva y liberación de memoria. No es necesario imprimir nada en pantalla.

---

### **Parte 2: Ejercicio en ordenador (Tiempo estimado: ¿45 minutos?) (5 p.)**

Implemente un programa en C que realice las siguientes tareas:

1. Solicite al usuario un número entero positivo que determinará el tamaño de un array de `double`.
2. Reserve dinámicamente memoria para el array.
3. Inicialice el array con valores que sigan la siguiente fórmula:
valor[i]= 1/(i+1)
4. Imprima en pantalla el contenido del array.
5. Aumente el tamaño del array al doble de su tamaño original y complete los nuevos valores con la misma fórmula.
6. Imprima en pantalla el contenido del array después de la expansión.
7. Libere la memoria utilizada correctamente.*/


/*Parte 3 (preguntas)

Cuando usamos realloc() para expandir un array, ocurren varias cosas en la memoria:

Preservación de valores:
Los valores almacenados en el array original se conservan en el nuevo bloque de memoria hasta donde se pueda copiar. Es decir, si la realocación es exitosa, los primeros n elementos (del tamaño original) se mantienen intactos en el nuevo bloque.

Posibilidad de expansión in situ o en un nuevo bloque:

Expansión en el mismo bloque: Si el espacio contiguo a la porción de memoria reservada originalmente está libre, realloc() puede simplemente ampliar el bloque en su ubicación actual, conservando la misma dirección de memoria.
Expansión en un bloque nuevo: Si no hay suficiente espacio contiguo para ampliar el bloque, realloc() asignará un nuevo bloque de memoria de mayor tamaño, copiará los datos del bloque original a la nueva ubicación y luego liberará el bloque original. En este caso, la dirección de memoria del array cambiará.

	//sería
	
    printf("Dirección original: %p\n", (void*)array);

*/