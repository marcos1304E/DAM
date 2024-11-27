#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*COMO FUNCIONAN LOS PUNTEROS CON LOS STRUCTS*/

//definimos las constantes
#define MAX_NOMBRE 20
#define MAX_ESTUDIANTES 20
#define MAX_BUFFER 200

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


void inicializar (Estudiante * estudiante_a_rellenar, char * nombre, int edad, float nota){

	//Esto no compila: estudainte_a_rellenar.edad = edad; pq estudiante_a_rellenar
	//es un puntero, no un estudiante.
	//Habria que hacer (*estudiante_a_rellenar.edad = edad;es decir,
	//acceder al contenido del puntero para poedr asi acceder al campo "edad" del estudiante.
	//En lugar de hacer eso, lo que C permite es utilizar el operador "->".
	estudiante_a_rellenar->edad = edad;

	estudiante_a_rellenar->nota= nota;
	//estudiante_a_rellenar.nombre = nombre; es incorrecto por una movida
	strcpy(estudiante_a_rellenar->nombre,nombre);
}

//Tiene que recibir un puntero a estudiante pq va a modificar la variable que recibe como argumento

//Cumpleanero es un puntero pq va a ser modificado en la función
void cumpleanios(Estudiante * cumpleanero){
	cumpleanero->edad++;


}

/*27/11 VAMOS A CREAR UNA FUNCION PARA IMPRIMIR UN ESTUDIANTE. LO VAMOS A HACER DE 2 FORMAS*/


//Recibe un estudiante y muestra por pantalla todos sus datos
void imprimirEstudiante(const Estudiante * estudiante_a_imprimir){ //Cuando paso por referencia apilo la direccion de memoria
printf("Nombre: %s\n", estudiante_a_imprimir->nombre);
printf("Edad: %d\n", estudiante_a_imprimir->edad);
printf("Nota: %f\n", estudiante_a_imprimir->nota);

}

//UNA FUNCION DE "IMPRIMIR" SIN LOS PRINTFS
//Convertir una estudiante a una cadena de texto

//esta funcion da warning pq la variable retval deja de existir cuando acaba la funcion
 char * estudianteToString(const Estudiante * datos){
 	char retval[MAX_BUFFER];
 	//snprintf (donde, cuando, el que[lo que harias con un printf] )
 	snprintf(retval,MAX_BUFFER,"El estudiante %s de %d años ha sacado un %f",datos->nombre,datos->edad,datos->nota);


 	return retval;//quiero que sea una variable del main que aqui se utiliza y aqui se rellena

}
char * estudianteToString(const Estudiante * datos,char * retval){
 	char retval[MAX_BUFFER];
 	//snprintf (donde, cuando, el que[lo que harias con un printf] )
 	snprintf(retval,sizeof(retval),"El estudiante %s de %d años ha sacado un %f",datos->nombre,datos->edad,datos->nota);


//No necesitamos un return retval


//crea una funcion que cree una cadena de texton con la informacion del estudiante.
//Puedes empezar creando una funcion que imprima x pantalla la info de un estudiante
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
	//El estudiante de la primera posicion ha cumplido años
	printf("Edad antigua de %s: %d\n",listado[0].nombre, listado->edad);
	cumpleanios(&listado[0]/*DIR DE MEMORIA*/ );


	//cumpleanios(&listado[0];
	printf("Edad nueva: %d\n",listado[0].edad);
	//Tambien es valido
	printf("Edad nueva :%d\n", listado->edad);
	printf("Edad nueva: %d\n", (*listado).edad);

	//printf("%d",(listado+6)-> edad);

	//VAMOS A IMPRIMIR ESTUDIANTES

	imprimirEstudiante(&listado[0]);
	char StringARellenar[MAX_BUFFER];
	estudianteToString(&listado[0], StringARellenar);
	printf("%s\n", StringARellenar);
}
	return 0;
}
