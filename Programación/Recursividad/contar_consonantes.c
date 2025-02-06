#include <stdio.h>
#include <stdlib.h>



int contar_consonantes(char *palabra, int i, int total_consonantes/*Se ponen todas las variables aquí*/){
	
	// BASE:
	if ( palabra[i] == '\0')
	{
		return total_consonantes;
	}
	

	if (palabra[i] != 'a' && palabra[i] != 'e' && palabra[i] != 'i' && palabra[i] != 'o' && palabra[i] != 'u' ){
		total_consonantes++;
	}

	total_consonantes = contar_consonantes(palabra,i+1,total_consonantes);



	return total_consonantes;

}



void contar_consonantes_2(char *palabra, int i, int * total_consonantes/*Se ponen todas las variables aquí*/){
	
	// BASE:
	if ( palabra[i] == '\0')
	{
		return ;
	}
	

	if (palabra[i] != 'a' && palabra[i] != 'e' && palabra[i] != 'i' && palabra[i] != 'o' && palabra[i] != 'u' ){
		(*total_consonantes)++;
	}

	contar_consonantes_2(palabra,i+1,total_consonantes);

}



int main(){

char palabra[20];

printf("Ingrese una palabra:");
scanf("%s",palabra);


	int total_consonantes = contar_consonantes(palabra, 0, 0);
	int total_consonantes_2 = 0;
	contar_consonantes_2(palabra, 0, &total_consonantes_2);
	printf("La palabra %s tiene %d consonantes\n", palabra, total_consonantes);
	printf("La palabra %s tiene %d consonantes\n", palabra, total_consonantes_2);

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