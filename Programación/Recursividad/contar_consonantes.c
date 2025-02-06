#include <stdio.h>
#include <stdlib.h>



int contar_consonantes(char *palabra, int i, int total_consonantes, int tamaño/*Se ponen todas las variables aquí*/){
	
	// BASE:
	if ( palabra[i] == '\0')
	{
		return 0;
	}
	

	if (palabra[i] != 'a' && palabra[i] != 'e' && palabra[i] != 'i' && palabra[i] != 'o' && palabra[i] != 'u' ){
		total_consonantes++;
	}

	contar_consonantes(palabra,i+1,total_consonantes,tamaño);
return 0;

}



int main(){

	int total_consonantes = contar_consonantes(palabra);
	printf("La palabra %s tiene %d consonantes\n", palabra, total_consonantes);

}


//De manera iterativa
/*
int contar_consonantes(char *palabra){


	int total_consonantes = 0;


	for (int i = 0; palabra[i] != '\0'; ++i)
	{
			if (palabra[i] != 'a' && palabra[i] != 'e' && palabra[i] != 'i' && palabra[i] != 'o' && palabra[i] != 'u' )
			{
				total_consonantes ++;
			}
	}
	return total_consonantes;
}

int main(){

char palabra[20];

printf("Ingrese una palabra:");
scanf("%s",palabra);


	int total_consonantes = contar_consonantes(palabra);
	printf("La palabra %s tiene %d consonantes\n", palabra, total_consonantes);


return 0;
}*/