/*Parte 1*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Función para determinar si un número es primo.
bool esPrimo(int num) {
    if (num < 2)
        return false;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0)
            return false;
    }
    return true;
}

int main(void) {
    int n;
    
    // Solicitar al usuario el tamaño del array
    printf("Ingrese un entero positivo para determinar el tamaño del array: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debe ingresar un entero positivo.\n");
        return 1;
    }
    
    // Reservar memoria dinámicamente para el array de enteros
    int *primos = malloc(n * sizeof(int));
    if (primos == NULL) {
        printf("Error en la asignación de memoria.\n");
        return 1;
    }
    
    // Llenar el array con los primeros n números primos
    int contador = 0;
    int numero = 2; // El primer número primo es el 2
    while (contador < n) {
        if (esPrimo(numero)) {
            primos[contador] = numero;
            contador++;
        }
        numero++;
    }
    
    // Imprimir el array de números primos
    printf("Los primeros %d números primos son:\n", n);
    for (int i = 0; i < n; i++) {
        printf("%d ", primos[i]);
    }
    printf("\n");
    
    // Liberar la memoria asignada
    free(primos);
    
    return 0;
}

/*Parte 2*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n;

    // 1. Solicitar al usuario el tamaño del array
    printf("Introduce un número entero positivo para determinar el tamaño del array: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debe ingresar un entero positivo.\n");
        return 1;
    }

    // 2. Reservar dinámicamente memoria para el array de double
    double *array = malloc(n * sizeof(double));
    if (array == NULL) {
        printf("Error en la asignación de memoria.\n");
        return 1;
    }

    // 3. Inicializar el array con la fórmula: valor[i] = 1 / (i + 1)
    for (int i = 0; i < n; i++) {
        array[i] = 1.0 / (i + 1);  // Se utiliza 1.0 para asegurar el cálculo en punto flotante
    }

    // 4. Imprimir en pantalla el contenido del array
    printf("Contenido del array:\n");
    for (int i = 0; i < n; i++) {
        printf("array[%d] = %lf\n", i, array[i]);
    }

    // Liberar la memoria reservada
    free(array);

    return 0;
}



//Parte 1
/*Escriba un programa en C que realice las siguientes acciones:

- Solicite un número entero positivo que determinará el tamaño de un array de enteros.
- Reserve memoria dinámicamente para el array.
- Llene el array con los primeros `n` números primos.
- Libere la memoria correctamente.

**Pregunta para razonar:**

Al liberar la memoria con `free()`, ¿los datos almacenados en el array desaparecen inmediatamente? ¿Qué ocurre si intentamos acceder a ellos después de liberar la memoria?*/


/*Al llamar a free(), el sistema marca el bloque de memoria como disponible para ser reutilizado, pero los datos en sí no se borran físicamente de la memoria de forma inmediata. Sin embargo, desde el punto de vista del programa, ese bloque ya no es válido y no se garantiza que los datos sean consistentes o correctos.

Acceder a la memoria liberada:
Intentar acceder a la memoria después de haberla liberado se considera comportamiento indefinido. Esto significa que:

El programa podría seguir mostrando los datos anteriores (al menos por un tiempo) si el contenido no ha sido sobrescrito.
Podría provocar errores de ejecución, como una violación de acceso (segmentation fault).
En otros casos, el programa puede comportarse de forma errática o inesperada.
Por lo tanto, es fundamental no acceder a la memoria una vez que se ha liberado, ya que se está accediendo a un área de memoria que el sistema podría reasignar a otras partes del programa o a otros procesos.*/

//Parte 2
/*1. Solicite al usuario un número entero positivo que determinará el tamaño de un array de `double`.
2. Reserve dinámicamente memoria para el array.
3. Inicialice el array con valores que sigan la siguiente fórmula:
valor[i]=1 / (i+1)
4. Imprima en pantalla el contenido del array.*/