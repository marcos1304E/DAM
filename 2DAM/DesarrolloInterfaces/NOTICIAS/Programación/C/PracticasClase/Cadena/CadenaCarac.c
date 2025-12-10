#include <stdio.h>
#include <stdlib.h>



int main(){
	char str1[5] = "hola";
	printf("%s\n",str1);
	printf("%c\n", str1[3]); //Imprime el cuarto caracter, pq se empieza a contar en 0. str[0]
	// ho\0a
	printf("%d\n",str1[4]);
	
	str1[4] = '$'; //Elimina el \0 y se seguira imprimiendo hasta que haya un \0 en la memoria.
	printf("%s\n",str1);
	return EXIT_SUCCESS;
}
