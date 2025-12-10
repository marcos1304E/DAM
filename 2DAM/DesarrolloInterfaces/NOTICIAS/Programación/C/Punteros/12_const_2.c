#include <stdio.h>
    
int main() {
    int numero = 10; //decalro como const un puntero(int*) no puedo modificar el contenido de la dir de memoria desde el pountero, pero si desde la variable
    int trampa = 30;
    const int *ptr = &numero;  // El valor apuntado es constante..Declara el contenido de ptr como constante, (dir de memoria)
                                            //lo que pudeo es cambiar la variable, no el contenido de otr, ya que lo he declarado como constante
    printf("Valor: %d\n", *ptr);

  // *ptr = 20;  // Esto daría un error porque el valor es constante
    numero = 20;   // Cambiar el valor directamente es válido
    printf("Nuevo valor: %d\n", *ptr);

    //VAMOS A TRAMPEAR
    ptr = &trampa;
    printf("Nuevo valor: %d\n", *ptr);

    return 0;
}   