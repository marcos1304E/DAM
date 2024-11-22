#include <stdio.h>
#include <stdlib.h>

/*COMO FUNCIONAN LOS PUNTEROS CON LOS STRUCTS*/

//definimos las constantes
#define MAX_NOMBRE 20
#define MAX_ESTUDIANTES 20

typedef struct{
	char nombre[MAX_NOMBRE];
	int edad;
	float nota;
} Estudiante;

/*Estudiante inicializar(char * nombre; int edad; float nota){
//Creo variable de tipo Estudiante
Estudiante estudiante_nuevo;
//Inicializo el estudiante--> e.edad = edad; e...
return estudiante_nuevo;
}*/

//Es valida, pero todavía no sabemos utilizarla
//Estudiante * inicializar(char * nombre; int edad; float nota){

//Estudiante * estudiante_nuevo = malloc //Memoria dinamica

//Inicializo

//return &estudiante_nuevo;
//}


void inicializar(Estudiante * estudiante_a_rellenar, char * nombre, int edad, float nota){

	//Esto no compila: estudainte_a_rellenar.edad = edad; pq estudiante_a_rellenar
	//es un puntero, no un estudiante.
	//Habria que hacer (*estudiante_a_rellenar.edad = edad;es decir,
	//acceder al contenido del puntero para poedr asi acceder al campo "edad" del estudiante.
	//En lugar de hacer eso, lo que C permite es utilizar el operador "->".
	estudiante_a_rellenar.edad = edad;

	estudiante_a_rellenar.nota= nota;
	//estudiante_a_rellenar.nombre = nombre; es incorrecto por una movida
	strcpy(estudiante_a_rellenar.nombre,nombre);

	int main(){

		int num_estudiantes;
		int edad;
		float nota;
		char nombre[MAX_NOMBRE];
		Estudiante listado[MAX_ESTUDIANTES];//Aqui se reserva la memoria para los estudiantes



		printf("%p\n", listado);
		printf("Sizeof listado: %lu\n", sizeof(listado)); //560 por la multiplicacion de bytes...
		printf("Sizeof estudiante: %lu\n",sizeof(Estudiante));

		printf("¿Cuantos estudiantes desea inicializar?");
		scanf("%d",&num_estudiantes);


		for(int i = 0; i < num_estudiantes;i++){
			printf("Introduce la edad: ");
			scanf("%d",&edad);
			printf("Introduce la nota: ");
			scanf("%f", &nota);

			printf("Introduce el nombre: ");
			scanf("%s", nombre);


			inicializar(/*direccion de memoria estudiante*/ listado,nombre,edad,nota);
			//inicializar ( &listado[0]...
		}
		return 0;
	}
