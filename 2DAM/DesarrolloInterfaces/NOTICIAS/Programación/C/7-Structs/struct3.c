#include <stdio.h>
#include <stdlib.h>
#define MAX_ITEMS 100
typedef struct {
	char nombre[100];
	char dirección[100];
	char telefono[20];
} Proveedor;
typedef struct{
	char nombre[100];
	float precio;
	Proveedor proveedor;
} Articulo;

typedef struct{
	Articulo articulos[MAX_ITEMS];
	int cantidades[MAX_ITEMS];
	int totalArticulos;
} Inventario;
int main(){
	Inventario miInventario;//DECLARACION
	//Esta forma de inicializar tn struct solofes valida en la declaración
	Articulo articulo = {"Nombre",10,{"NomPro","DirPro","telPro"}};//DECLARACION E INICIALIZACION
       	//La inicializacion con llaves solo ES VALIDA en la declaración de variables
	miInventario.articulos[0] = articulo;
	miInventario.cantidades[0] = 10; //INICIALIZACION
	printf("Nombre articulo: %s\n",
			miInventario.articulos[0].nombre
	      );

	printf("Cantidad: %d\n",
			miInventario.cantidades[0]
	      );
	printf("Nombre del proveedor: %s\n",
			miInventario.articulos[0].proveedor.nombre
	      );
	//aqui, que miInventario ya está declarada,
	//no puedo inicializarla asi: miInventario = {}
	return 0;
}
