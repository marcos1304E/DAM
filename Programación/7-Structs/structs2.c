#include <stdio.h>



int main() {
	Vehiculo miVehiculo;

	miVehiculo.marca = "Toyota";
	miVehiculo.modelo = "Corolla";
	miVehiculo.anio = 2021;
	miVehiculo.kilometraje = 15000;

	printf("Marca: %s\n", miVehiculo.marca);
	printf("Modelo: %s\n", miVehiculo.modelo);
	printf("Año: %d\n", miVehiculo.anio);
	printf("Kilometraje: %d km\n", miVehiculo.kilometraje);

	return 0;
}
