#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TITULO_MAX 60 //Longitud maxima del titulo del libro
#define AUTOR_MAX 50 //Longitud maxima del autor del libro
int CAT_MAX = 40;
//int total_libros= 0; //CAT_MAX es el numero maximo de libros en el catalogo, y total_libros llevara la cuenta de los libros añadidos

/*
Autor: Marcos Escamilla Ojeda
Desarrollo de Aplicaciones Multiplataforma
Programación
Practica 6 -- Gestión de biblioteca mejorada


//1 argumentos linea comandos
//main(int argc, char **argv)
        //char ** argv[]
    // ./a.out mostrar 15
/* argv[0] es un puntero*/

//2. memoria dinamica
/*Inicializar libro (d, datos)
donde d: es una direccion de memoria donde almacenar el libro y datos es id, "titulo","auto"...
-> añadir libro al catalogo
(utilice inicializa)
La inicializacion del catálogo hay que cambiarla*/

//3.prevencion de errores


typedef enum{ //Enum para que se definan directamente, equivaldria a poner arriba varios defines con #define FICCION 0, por ejemplo, pero mucho más sencillo así y nos podemos entender para que abajo en el codigo si podamos poner la palabra literal FICCION, si no tendríamos que poner un 0.
	FICCION, // Representando el genero de ficcion, equivalente al número 0.
	NO_FICCION, // 1
	POESIA, // 2
	TEATRO, // 3
	ENSAYO // 4
            //Así respectivamente
} Genero_literario;

typedef struct{ //Aqui definimos un struct llamado Libro, que agrupa toda la informacion que puede tener el libro, id, titulo, un autor, un precio, una categoria que será de tipo Genero_literario y la cantidad disponible
	int id;    //Identificador unico del libro
	char titulo[TITULO_MAX];//titulo(hasta 60 caracteres maximo)
	char autor[AUTOR_MAX];//nombre del autor(50 caracteres maximo)
	float precio;//precio
	int categoria;//genero del libro, usando el tipo Genero_literario definido antes
	int cantidad;//cantidad disponible en el stock

} Libro;


//Aqui ponemos todas las funciones void, y abajo las desarrollamos
void inicializarLibro(Libro * dir, int id,char *titulo, char* autor,float precio, int categoria, int cantidad, int * total_libros);


void AñadirLibro(Libro ** catalogo, int *total_libros);


void imprimirLibro(const Libro * puntero_a_un_unico_libro);


void libroPorId(const Libro * catalogo, int id);


void imprimirTodosLosLibros (const Libro * puntero_al_primer_libro_del_catalogo);
        

void libroPorCategoria(Libro * catalogo, int categoria);


void libroPorAutor(Libro * catalogo, char *autor_a_buscar);


void IncrementarStock(Libro * stock_libro, int id, int cantidad);


int main(int argc, char ** argv){ //int main(int argc, char ** argv){}...
            //2 parametros recibidos, argc y argv
            //argc: número de argumentos recibidos
            //argv: array de cadenas de texto

        int numero_libros, id, autor_a_buscar;
        int total_libros = 0;
// Declaración de variables enteras:
    // numero_libros: almacenará el número de libros en el catálogo.
    // id: identificador de un libro.
    // cantidad: cantidad de libros que se desean añadir o incrementar.

        
    // Reserva de memoria dinámica para el catálogo de libros

        Libro * libros = (Libro*) malloc(40 * sizeof(Libro));
    // Inicialización de los libros del catalogo

// Se usa malloc para reservar memoria dinámica suficiente para un array de 'Libro'.
    // El tamaño reservado es 'cantidad' veces el tamaño de un 'Libro'.
    // Se hace un casting explícito a 'Libro*' porque malloc devuelve un puntero void*.
        inicializarLibro(&libros[0],1, "To Kill a Mockingbird", "Harper Lee", 15.99,FICCION, 10, &total_libros);
        inicializarLibro(&libros[1],2, "1984", "George Orwell", 12.49,FICCION, 5, &total_libros);
        inicializarLibro(&libros[2],3, "The Great Gatsby", "F. Scott Fitzgerald", 10.99,FICCION, 8, &total_libros);
        inicializarLibro(&libros[3],4, "Moby Dick", "Herman Melville", 18.99,FICCION, 12, &total_libros);
        inicializarLibro(&libros[4],5, "War and Peace", "Leo Tolstoy", 20.00,FICCION, 7, &total_libros);
        inicializarLibro(&libros[5],6, "Pride and Prejudice", "Jane Austen", 14.99,FICCION, 9, &total_libros);
        inicializarLibro(&libros[6],7, "The Catcher in the Rye", "J.D. Salinger", 10.00,FICCION, 6, &total_libros);
        inicializarLibro(&libros[7],8, "The Odyssey", "Homer", 17.49,FICCION, 4, &total_libros);
        inicializarLibro(&libros[8],9, "Ulysses", "James Joyce", 25.00,FICCION, 2, &total_libros);
        inicializarLibro(&libros[9],10, "The Divine Comedy", "Dante Alighieri", 22.00, POESIA, 3, &total_libros);
        inicializarLibro(&libros[10],11, "Leaves of Grass", "Walt Whitman", 13.00, POESIA, 11, &total_libros);
        inicializarLibro(&libros[11],12, "The Iliad", "Homer", 18.50,FICCION, 7, &total_libros);
        inicializarLibro(&libros[12],13, "A Brief History of Time", "Stephen Hawking", 15.00, NO_FICCION, 15, &total_libros);
        inicializarLibro(&libros[13],14, "The Art of War", "Sun Tzu", 9.99, NO_FICCION, 20, &total_libros);
        inicializarLibro(&libros[14],15, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 16.49, NO_FICCION, 13, &total_libros);
        inicializarLibro(&libros[15],16, "The Selfish Gene", "Richard Dawkins", 14.00, NO_FICCION, 6, &total_libros);
        inicializarLibro(&libros[16],17, "The Road to Serfdom", "F.A. Hayek", 10.50, NO_FICCION, 5, &total_libros);
        inicializarLibro(&libros[17],18, "The Wealth of Nations", "Adam Smith", 30.00, NO_FICCION, 8, &total_libros);
        inicializarLibro(&libros[18],19, "On the Origin of Species", "Charles Darwin", 24.99, NO_FICCION, 4, &total_libros);
        inicializarLibro(&libros[19],20, "The Prince", "Niccolò Machiavelli", 8.99, NO_FICCION, 14, &total_libros);
        inicializarLibro(&libros[20],21, "Hamlet", "William Shakespeare", 11.50, TEATRO, 6, &total_libros);
        inicializarLibro(&libros[21],22, "Macbeth", "William Shakespeare", 9.50, TEATRO, 8, &total_libros);
        inicializarLibro(&libros[22],23, "Othello", "William Shakespeare", 10.99, TEATRO, 7, &total_libros);
        inicializarLibro(&libros[23],24, "A Doll's House", "Henrik Ibsen", 12.50, TEATRO, 5, &total_libros);
        inicializarLibro(&libros[24],25, "Waiting for Godot", "Samuel Beckett", 13.99, TEATRO, 4, &total_libros);
        inicializarLibro(&libros[25],26, "Death of a Salesman", "Arthur Miller", 14.99, TEATRO, 10, &total_libros);
        inicializarLibro(&libros[26],27, "The Glass Menagerie", "Tennessee Williams", 11.00, TEATRO, 9, &total_libros);
        inicializarLibro(&libros[27],28, "Long Day's Journey into Night", "Eugene O'Neill", 19.50, TEATRO, 3, &total_libros);
        inicializarLibro(&libros[28],29, "The Importance of Being Earnest", "Oscar Wilde", 8.50, TEATRO, 15, &total_libros);
        inicializarLibro(&libros[29],30, "The Waste Land", "T.S. Eliot", 6.99, POESIA, 10, &total_libros);
        inicializarLibro(&libros[30],31, "Paradise Lost", "John Milton", 12.00, POESIA, 7, &total_libros);
        inicializarLibro(&libros[31],32, "Beowulf", "Anonymous", 15.00, POESIA, 5, &total_libros);
        inicializarLibro(&libros[32],33, "Essays", "Michel de Montaigne", 20.00, ENSAYO, 4, &total_libros);
        inicializarLibro(&libros[33],34, "Self-Reliance and Other Essays", "Ralph Waldo Emerson", 9.00, ENSAYO, 9, &total_libros);
        inicializarLibro(&libros[34],35, "Civil Disobedience and Other Essays", "Henry David Thoreau", 7.50, ENSAYO, 11, &total_libros);
        inicializarLibro(&libros[35],36, "Meditations", "Marcus Aurelius", 11.99, ENSAYO, 8, &total_libros);
        inicializarLibro(&libros[36],37, "The Federalist Papers", "Alexander Hamilton, James Madison, John Jay", 18.00, ENSAYO, 5, &total_libros);
        inicializarLibro(&libros[37],38, "The Communist Manifesto", "Karl Marx and Friedrich Engels", 5.99, ENSAYO, 12, &total_libros);
        inicializarLibro(&libros[38],39, "The Republic", "Plato", 16.00, ENSAYO, 6, &total_libros);
        inicializarLibro(&libros[39],40, "Thus Spoke Zarathustra", "Friedrich Nietzsche", 14.99, ENSAYO, 10, &total_libros);    


printf("Lista de argumentos (hay %d argumentos):\n",argc);
// Imprime el número total de argumentos recibidos.
    for(int i = 0; i<argc; i++){
        printf("\t Argumento %d: %s\n\n",i,argv[i]);
        // Bucle que recorre e imprime cada argumento pasado por línea de comandos.
    }


if (argc == 1){
    printf("Error, pon algun argumento. introduce \nmostrar(para imprimir todos los libros del catalogo), \nmostrar (ID), \nautor (Autor a buscar), \nañadir, categoria (0,1,2,3,4, si solo pones categoría te dice los generos disponibles)\n \n");
    // Si no se recibe ningún argumento adicional, se muestra un mensaje de error.
    }

else if (argc == 2){

    if (strcmp(argv[1], "categoria") == 0) {
        printf("Las categorías disponibles son:\n");
        printf("  0 = Ficción\n");
        printf("  1 = No Ficción\n");
        printf("  2 = Poesía\n");
        printf("  3 = Teatro\n");
        printf("  4 = Ensayo\n");
    }

    // Si se pasa un argumento, se verifica si es 'mostrar' o 'añadir'.
    if (strcmp(argv[1], "mostrar") == 0){
        // Si el argumento es 'mostrar', se imprime la lista completa de libros.
        imprimirTodosLosLibros(libros);
    } else if(strcmp(argv[1],"añadir")== 0){
   // Si el argumento es 'añadir', se llama a la función para añadir un nuevo libro.
        
        AñadirLibro(&libros, &total_libros);
        imprimirTodosLosLibros(libros);
        // Luego se imprime la lista completa de libros para confirmar el cambio.
    
    } else{
        printf("Argumento no reconozido, solamente introduce \nmostrar(para imprimir todos los libros del catalogo), \nmostrar (ID), \nautor (Autor a buscar), \nañadir, categoria (0,1,2,3,4, si solo pones categoría te dice los generos disponibles)\n");
    }

} else if (argc == 3){
// Si se reciben dos argumentos adicionales, se verifican distintos comandos.
    if (strcmp(argv[1], "mostrar")== 0)
    {
        int id = atoi(argv[2]);
        // Convierte el segundo argumento de texto a entero para usarlo como ID.
        libroPorId(libros,id);
        // Llama a la función que muestra el libro con el ID especificado.
    } else if (strcmp(argv[1], "autor")== 0)
    {
        char *autor_a_buscar = argv[2];
      libroPorAutor(libros,argv[2]);

      // Si el comando es 'autor', se busca y muestra el libro del autor solicitado.


    }
    else if (strcmp(argv[1], "categoria")== 0)
    {


        int categoria = atoi(argv[2]);

        if (categoria < 0 || categoria > 4) {
            printf("Error: Categoría inválida. Solo se aceptan las categorías 0, 1, 2, 3 y 4.\n Equivalente a ficcion, no ficcion, poesia, teatro y ensayo, respectivamente.\n");
            return 1;
}


        // Convierte el argumento de texto a entero para usarlo como categoría.
        libroPorCategoria(libros,categoria);
        // Llama a la función que busca libros por categoría.
    }
}else if (argc == 4){
    // Si se reciben tres argumentos adicionales, se interpreta como un comando para
        // incrementar el stock de un libro.
    int id = atoi(argv[2]);
    // Convierte el segundo argumento a entero (ID del libro).
    int cantidad = atoi(argv[3]);
    // Convierte el tercer argumento a entero (cantidad a incrementar).

    IncrementarStock(libros,id,cantidad);
    // Llama a la función que incrementa el stock del libro correspondiente.

}
free(libros);
return 0;
}


// La función 'inicializarLibro' recibe la dirección del libro en el array y lo inicializa
    // con los valores dados (ID, título, autor, precio, categoría y stock disponible).

/*Esta función inicializa un libro con los datos que se le pasan como parámetros. Recibe un puntero a una estructura 
de tipo Libro donde guardará los datos. Se asignan los valores del ID, precio, categoría, etc., y se copia el texto 
del título y el autor usando strcpy porque son cadenas de caracteres. */

    // Devuelve 0 para indicar que el programa ha finalizado correctamente.
void inicializarLibro(Libro * dir, int id,char *titulo, char* autor,float precio, int categoria, int cantidad, int * total_libros){//Muestra info de libro al que se le apunte
        //Con todas las propiedades del libro, id titulo, autor, precio, genero y cantidad
        dir -> id = id;//asignamos el id del libro
        dir ->precio = precio;//asignamos el precio
        dir -> categoria = categoria;//asignamos la categoria
        strcpy(dir-> autor, autor);// Copiamos el nombre del autor en el campo autor de la estructura.
        strcpy(dir-> titulo, titulo);// Copiamos el título del libro en el campo titulo de la estructura.
        dir -> cantidad = cantidad;//Asignamos la cantidad de libros disponibles.

        (*total_libros)++;// Incrementamos el total de libros.
        //Accedemos al contenido y despues incrementamos


}

// La función "AñadirLibro" permite al usuario añadir nuevos libros al catálogo. 
// Primero pregunta cuántos libros quiere añadir, luego pide los datos de cada libro (ID, título, autor, etc.). 
// Uso un bucle para repetir esta operación tantas veces como libros se quieran añadir.
void AñadirLibro(Libro ** catalogo, int *total_libros){

    int id = *total_libros+1;
    int num_nuevos, cantidad, categoria;
    float precio;
    char titulo[60];
    char autor[40];
    printf("¿Cuántos libros quieres añadir?\n");
    scanf("%d", &num_nuevos);


CAT_MAX += num_nuevos;
*catalogo = (Libro *)realloc (*catalogo, CAT_MAX * sizeof(Libro));
//Libro libro_nuevo; //declaramos variable libro_nuevo de tipo Libro, para almacenar datos de cada nuevo libro que se añad
for (int i = 0; i < num_nuevos; ++i)
{

printf("Datos del nuevo libro:\n");
printf("Id: %d\n",*total_libros);
// Escribirt en libro_nuevo.id
//libro_nuevo.id = *total_libros+1; //aqui asignamos un ID unico al nuevo libro

printf("Titulo:");
scanf(" %s", titulo);

printf("Autor:");
scanf(" %s", autor);

printf("Precio:");
scanf(" %f", &precio);

printf("Categoria:");
scanf("%d", &categoria);

printf("Cantidad:");
scanf(" %d", &cantidad);

// Llamamos a la función inicializarLibro para guardar los datos en el catálogo.
inicializarLibro(&((*catalogo)[*total_libros]),id,titulo,autor,precio,categoria,cantidad, total_libros);

}
}

// Esta función muestra por pantalla toda la información de un libro específico. 
// Recibe un puntero a un libro y usa printf para imprimir sus datos.
//Ponemos const para que no se cambie, siempre el mismo sin modificar
void imprimirLibro(const Libro * puntero_a_un_unico_libro){//Muestra info de libro al que se le apunte
        //Con todas las propiedades del libro, id titulo, autor, precio, genero y cantidad
        printf("Id: %d\n",puntero_a_un_unico_libro->id);
        printf("Titulo: %s\n",puntero_a_un_unico_libro->titulo);
        printf("Autor: %s\n",puntero_a_un_unico_libro->autor);
        printf("Precio: %.2f\n",puntero_a_un_unico_libro->precio);
        printf("Genero: %d\n",puntero_a_un_unico_libro->categoria);
        printf("Cantidad: %d\n",puntero_a_un_unico_libro->cantidad);

}
// La función "libroPorId" busca un libro en el catálogo según el ID que introduzca el usuario. 
// Usa un bucle para recorrer el catálogo completo y cuando encuentra el libro con el ID deseado, 
// llama a la función imprimirLibro para mostrar sus datos.
void libroPorId(const Libro * catalogo, int id){

        for(int i=0; i <= CAT_MAX; i++){ //Bucle para que recorra todos los libros hasta el id que el usuario introduzca, y ahi imprimir el libro con la id que se ha introducido
            if(catalogo[i].id == id){ //Por eso hemos recorrido todo con el bucle for, y hemos llamado a la funcion imprimirLibro, en vez de hacer un printf para que imprima el libro completo, funcion que hemos hecho arriba, con todos los printf de todas las propiedades del libro.
                //comparamos el id de cada libro con el id introducido
            imprimirLibro(&catalogo[i]); //si coincide, mostramos los datos de ese libro
                       

        }
}
}

// Esta función recorre todo el catálogo y muestra la información de todos los libros usando imprimirLibro.Usa un bucle para recorrer el catálogo y llama a imprimirLibro para cada libro.

void imprimirTodosLosLibros (const Libro * puntero_al_primer_libro_del_catalogo){
        for(int i = 0;i < CAT_MAX; i++){
                imprimirLibro(puntero_al_primer_libro_del_catalogo+i);//ponemos un +i para que vaya sumando cada vez, una vez i, y que vaya imprimiendo cada vez el libro siguiente
        }                                                         //Para no tener que ir repitiendo todo el rato todos los libros lo hacemos en un bucle
}
        
/*
Esta función busca y muestra los libros de una categoría específica.
Recorre el catálogo y llama a imprimirLibro para cada libro que coincida con la categoría proporcionada.
*/
void libroPorCategoria(Libro * catalogo, int categoria){ //Para buscar por la categoría 
    /*vale tanto poner 0(ficcion), 1(no ficcion)...
    hasta tambien poner el genero en la propia palabra: "ficcion"...*/
    printf("Libros de categoria %d\n", categoria); //Bucle que recorre todos los libros, y cuando encuentra un libro de la categoria que hemos puesto, imprime ese libro
        for(int i = 0; i < CAT_MAX; i++){
            if(catalogo[i].categoria == categoria){
                            //Cuando encuentra los libros de esa categoria, imprime los libros de esa categoría
                imprimirLibro(&catalogo[i]);
            }

        }

}
/*
Esta función busca libros por autor.
Compara el nombre del autor de cada libro con el autor buscado.
*/
void libroPorAutor(Libro * catalogo, char *autor_a_buscar){
    
    int libro_encontrado = 0;  // definimos variable para indicar si se encuentra o no el libro
    
    for (int i = 0; i < CAT_MAX; ++i) {//recorremos todo el catalogo con un bucle for

        if (strstr(catalogo[i].autor, autor_a_buscar) != NULL) {//aqui usamos strstr para buscar si el nombre del autor que se ingrese aparece en el campo autor de cada libro, entonces si encuentra alguna coincidencia si que llama a imprimirLibro, para ahi ya mostrar toda la informacion del libro, y cambiamos a 1 el indicadore de que si se ha encontrado algun autor con las coincidencias
            //Asi por ejemplo, poniendo solo el apellido del autor tambien funcionaría
            imprimirLibro(&catalogo[i]);  
            libro_encontrado = 1;
        }
    }
    
    if (!libro_encontrado) {
        printf("No se ha encontrado ningún libro del autor: %s\n", autor_a_buscar);
    }//Mensaje para saber, si sigue siendo 0 el indicador, significa que no hay libros de ese autor y entonces imprimimos un mensaje diciendo que no se ha encontrado ningun resulyado
}


/*
Esta función incrementa la cantidad en stock de un libro específico.
Busca el libro por su ID y aumenta su cantidad según lo especificado.
*/
void IncrementarStock(Libro * stock_libro, int id, int cantidad){ //Aqui no se podría poner const Libro porque se está modificando el libro, entonces me daría un warning

        for(int i = 0; i < CAT_MAX; i++){//Bucle que recorre todos el catalogo hasta encontrar el libros que le hemos introducido
            if (/*id del libro i == id introducido por el scanf*/stock_libro[i].id == id){

                stock_libro[i].cantidad += cantidad;//Para que se le sume a la cantidad de stock la cantidad agregada por el usuario
                printf("El libro ha sido actualizado, la nueva cantidad en stock es: %d\n", stock_libro[i].cantidad);//actualizamos stock


            }
    
    }
}


