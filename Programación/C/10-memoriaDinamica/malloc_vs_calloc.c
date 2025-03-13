#include <stdio.h>
#include <stdlib.h>// Para malloc, free, etc.

int main() {
    int n = 5;
    //int *arr = (int *)calloc(n, sizeof(int)); // Reserva e inicializa a cero

    //int arr[5];//reserva estática

    int * arr = (int *) malloc(5*sizeof(int));//Solo reserva, pero no lo toca.
    if (arr == NULL) {
        printf("Error: no se pudo asignar memoria.\n");
        return 1;
    }
    // arr[i] estará inicialmente en 0
    for (int i = 0; i < n; i++) {
          printf("arr[%d] = %d\n", i, arr[i]);
            //Al ahaber reservado malloc, no se sabe que valor va a haber almacenado

          //printf("arr[%d] = %d", i, *(arr+i));
    }


    //LO MISMO CON CALLOC
    int * arr2 = (int *) calloc(5,sizeof(int));
    //reserva la memoria e inicializa a 0
    if(arr2 == NULL){

        printf("eror: no se pudo asignar memoria\n");
        return 1;
    }
    for (int i = 0; i < n; i++){
        printf("arr2[%d] = %d\n", i, arr2[i]);
    }



int suma;



    free(arr);
    free(arr2);
    return 0;
    }


