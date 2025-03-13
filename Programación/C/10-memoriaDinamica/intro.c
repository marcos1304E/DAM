#include <stdio.h>
#include <stdlib.h> // Para malloc, free, etc.

int main() {
    int * p_error = malloc(sizeof(int)); // Reservar espacio para un int
    //Aqui hay un casting implicito
    //malloc devuelve un void*.Hay que convertirlo para poder utilizarlo.



int *p = (int *) malloc (sizeof(int));
//esta es la buena practica

    if (p == NULL) { //Malloc ha fallado, puede fallar pq no hay memoria disponible, no deberia pasar, pero hay que tener cuidado, el codigo no seguiria, 
        //o lo acabas tu o sigues ejecutando
        //y el programa peta
        printf("Error: no se pudo asignar memoria.\n");
        return 1; //El programa ha fallado
    }
                                                                //Tiene que haber tantos frees como malloc en el programa
    *p = 42; // Usamos la memoria
    printf("El valor es: %d\n", *p);
    free(p_error); // Liberamos la memoria reservada
    return 0;
}
