#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Vehiculo{
	char marca[100];
	char modelo[100];
	int anio;
	int kilometraje;
} Vehiculo;

int main() {
	Vehiculo miVehiculo;

	strcpy(miVehiculo.marca, "Toyota");
	strcpy(miVehiculo.modelo, "Corolla");
	miVehiculo.anio = 2021;
	miVehiculo.kilometraje = 15000;

	printf("Marca: %s\n", miVehiculo.marca);
	printf("Modelo: %s\n", miVehiculo.modelo);
	printf("Año: %d\n", miVehiculo.anio);
	printf("Kilometraje: %d km\n", miVehiculo.kilometraje);

	return 0;
}
