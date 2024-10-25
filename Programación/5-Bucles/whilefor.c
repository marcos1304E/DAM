#include <stdio.h>
#include <stdlib.h>



int main(){

	int i = 0;
	
	for (/*valor inicial*/ i=0 ; i<5/*condicion*/ ; i = i + 1/*Codigo a ejecuitar entre vueltas*/ ){
	
printf("%d", 1);
	}
	printf("Terminado\n");
	

//Traducimos a while

	i=0;
	while(i<5){
		printf("%d",i); //El interior del for
				//Codigo entre vueltas
				
	}
	printf("Terminado el while\n");


	return 0;
}
