#include <stdio.h>
#include <stdlib.h>

/*
Marcos Escamilla Ojeda
*/

int main() {

    int size1, size2;
    
    printf("Introduce el tamaño del primer array entero y positivo: ");
    if (scanf("%d", &size1) != 1 || size1 <= 0) {
        printf("introduce un numero entero positivo.\n");
        return 1;
    }
    
    int *array1 = malloc(size1 * sizeof(int));
    if (array1 == NULL) {
        printf("Error para asignar memoria\n");
        return 1;
    }

    for (int i = 0; i < size1; i++) {
        array1[i] = (i + 1) * 3; // Por ejemplo
    }

    printf("Introduce el tamaño del segundo array entero y positivo: ");
    if (scanf("%d", &size2) != 1 || size2 <= 0) {
        printf("introduce un numero entero positivo.\n");
        free(array1);
        return 1;
    }

    int *array2 = malloc(size2 * sizeof(int));
    if (array2 == NULL) {
        printf("Error para asignar memoria\n");
        free(array1);
        return 1;
        }
    for (int i = 0; i < size2; i++) {
        array2[i] = (i + 1) * 5; // Le pongo otro valor, por ejemplo el 5
    }

    char opcion;
    printf("Que operacion quieres hacer\n");
    printf("  C - Concatenar los arrays\n");
    printf("  S - Sumar coordenada a coordenada\n");
    printf("Introduce la opción:\n");
    scanf(" %c", &opcion);
    
    int *resultado = NULL; // Array resultante
    int size_resultado = 0;

    if (opcion == 'S' || opcion == 's') {
        // Para sumar coordenada a coordenada, los arrays deben tener el mismo tamaño
        if (size1 != size2) {
            printf("Error: Para sumar coordenada a coordenada, ambos arrays deben tener el mismo tamaño.\n");
            free(array1);
            free(array2);
            return 1;
        }

        size_resultado = size1; // O size2, ya que son iguales
        resultado = malloc(size_resultado * sizeof(int));
        if (resultado == NULL) {
            printf("Error en la asignación de memoria para el array resultado.\n");
            free(array1);
            free(array2);
            return 1;
        }
        for (int i = 0; i < size_resultado; i++) {
            resultado[i] = array1[i] + array2[i];
        }
    }
    else if (opcion == 'C' || opcion == 'c') {
        size_resultado = size1 + size2; //Hago la suma de los dos tamaños para concatenar
        resultado = malloc(size_resultado * sizeof(int));
        if (resultado == NULL) {
            printf("Error en la asignación de memoria para el array resultado.\n");
            free(array1);
            free(array2);
            return 1;
        }

        for (int i = 0; i < size1; i++) {
            resultado[i] = array1[i];
        }
        //Primer y segundo array
        for (int i = 0; i < size2; i++) {
            resultado[size1 + i] = array2[i];
        }
    }

else {
        printf("La opción no es válida.\n");
        free(array1);
        free(array2);
        return 1;
    }
    
        printf("\nArray resultado:\n");
    for (int i = 0; i < size_resultado; i++) {
        printf("%d ", resultado[i]);
    }

    printf("\n");
    

    free(array1);
    free(array2);
    free(resultado);
    
    return 0;
}