#include <stdio.h>
#include <stdbool.h> // Para usar bool

int main() {
    bool esMayorDeEdad; // Definimos una variable de tipo bool
    
    int edad;
    
    printf("Introduce tu edad: ");
    scanf("%d", &edad);
    
    // Usamos el tipo bool para evaluar si la persona es mayor de edad
    esMayorDeEdad = (edad >= 18); // Si la edad es 18 o más, esMayorDeEdad será true
    
    if (esMayorDeEdad) {
        printf("Eres mayor de edad.\n");
    } else {
        printf("No eres mayor de edad.\n");
    }

    return 0;
}
