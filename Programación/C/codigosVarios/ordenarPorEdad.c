#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NOMBRE 50  // Longitud máxima para el nombre de una persona

// ======================================================================
// 1. Declaración de la estructura que almacena información de una persona
// ======================================================================
typedef struct {
    char nombre[MAX_NOMBRE];
    int edad;
} Persona;

// ======================================================================
// 2. Función de comparación para ordenar las personas por edad (para usar con qsort)
// ======================================================================
int compararPersonas(const void *a, const void *b) {
    Persona *p1 = (Persona *)a;
    Persona *p2 = (Persona *)b;
    return p1->edad - p2->edad;
}

int main() {
    int n;

    // ----------------------------------------------------------------------
    // Solicitar un número entero positivo (cantidad de personas)
    // ----------------------------------------------------------------------
    printf("Ingrese el número de personas: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Error: Debe ingresar un número entero positivo.\n");
        return 1;
    }

    // ----------------------------------------------------------------------
    // Reserva de memoria dinámica para un arreglo de 'n' estructuras Persona
    // ----------------------------------------------------------------------
    Persona *personas = (Persona *)malloc(n * sizeof(Persona));
    if (personas == NULL) {
        printf("Error al reservar memoria para las personas.\n");
        return 1;
    }

    // ----------------------------------------------------------------------
    // Rellenar el arreglo de estructuras con los datos ingresados por el usuario
    // ----------------------------------------------------------------------
    for (int i = 0; i < n; i++) {
        printf("\nPersona %d:\n", i + 1);
        
        // Se limpia el buffer de entrada en caso de que queden caracteres residuales
        while (getchar() != '\n');

        // Ingresar el nombre
        printf("Ingrese el nombre: ");
        if (fgets(personas[i].nombre, MAX_NOMBRE, stdin) == NULL) {
            printf("Error al leer el nombre.\n");
            free(personas);
            return 1;
        }
        // Eliminar el salto de línea si se ha almacenado
        personas[i].nombre[strcspn(personas[i].nombre, "\n")] = '\0';

        // Ingresar la edad
        printf("Ingrese la edad: ");
        if (scanf("%d", &personas[i].edad) != 1) {
            printf("Error al leer la edad.\n");
            free(personas);
            return 1;
        }
    }

    // ----------------------------------------------------------------------
    // Procesar la información:
    // Por ejemplo, ordenar el arreglo de personas por edad usando la función qsort.
    // (Aquí se puede insertar cualquier otro procesamiento que te soliciten)
    // ----------------------------------------------------------------------
    qsort(personas, n, sizeof(Persona), compararPersonas);

    // ----------------------------------------------------------------------
    // Mostrar la lista de personas ordenada por edad
    // ----------------------------------------------------------------------
    printf("\nPersonas ordenadas por edad:\n");
    for (int i = 0; i < n; i++) {
        printf("Nombre: %s, Edad: %d\n", personas[i].nombre, personas[i].edad);
    }

    // ----------------------------------------------------------------------
    // Liberar la memoria utilizada
    // ----------------------------------------------------------------------
    free(personas);

    return 0;
}