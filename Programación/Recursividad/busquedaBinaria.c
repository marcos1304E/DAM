#include <stdlib.h>
#include <stdio.h>

int busquedaBinaria(int * array, int a_buscar, int ini, int fin);//int ini e int fin son las posiciones del array, y van cambiando.



int main(){
	
	int arr[10]={-5,1,9,10,11,12,17,120,150,1500}
	
	int a_buscar=120;

	int encontrado = busquedaBinaria(array, 120,0,9);

	int tam= sizeof(array)/sizeof(array[0]);

	int ini = busquedaBinaria(array,0,n-1,)

/*si la posicion de la mitad es mayor que el valor buscado llamo a busqueda_binaria con la mitad de la izquierda, es decir, desde inicio hasta la mitad.*/


int mitad = (ini + fin)/2;
//si hago variable mitad, me dará siempre como resultado la mitad de la posicion, ya que he sumado el inicio + el fin y lo he dividido entre 2.
//array[mitad] con pos a buscar

if (a_buscar == array [mitad]) //Este primer if si es la base, y luego el segundo if pasa a ser parte de la recursión, ya que siempre se tiene las dos partes
{
	return 1;	
}
else if (a_buscar < array[mitad])
{
	return busquedaRecursiva (array,a_buscar,ini,mitad);
}

else{
	return busquedaRecursiva(array, a_buscar, mitad, fin);
}


}