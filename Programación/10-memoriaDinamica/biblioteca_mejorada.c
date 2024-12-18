#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TITULO_MAX 60
#define AUTOR_MAX 50
#define CAT_MAX 40

/*
Autor: Marcos Escamilla Ojeda
Desarrollo de Aplicaciones Multiplataforma
Programación
Practica 6 -- Gestión de biblioteca

*/ //mas comentarios


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
	FICCION, // 0
	NO_FICCION, // 1
	POESIA, // 2
	TEATRO, // 3
	ENSAYO // 4

} Genero_literario;

typedef struct{
	int id;
	char titulo[TITULO_MAX];
	char autor[AUTOR_MAX];
	float precio;
	int categoria;
	int cantidad;

} Libro;




//Ponemos const para que no se cambie, siempre el mismo sin modificar
void printBook(const Libro * puntero_a_un_unico_libro){//Muestra info de libro al que se le apunte
        //Con todas las propiedades del libro, id titulo, autor, precio, genero y cantidad
        printf("Id: %d\n",puntero_a_un_unico_libro->id);
        printf("Titulo: %s\n",puntero_a_un_unico_libro->titulo);
        printf("Autor: %s\n",puntero_a_un_unico_libro->autor);
        printf("Precio: %.2f\n",puntero_a_un_unico_libro->precio);
        printf("Genero: %d\n",puntero_a_un_unico_libro->categoria);
        printf("Cantidad: %d\n",puntero_a_un_unico_libro->cantidad);

}


void libroPorId(const Libro * catalogo, int id){

        for(int i=0; i <= CAT_MAX; i++){ //Bucle para que recorra todos los libros hasta el id que el usuario introduzca, y ahi imprimir el libro con la id que se ha introducido
            if(catalogo[i].id == id){ //Por eso hemos recorrido todo con el bucle for, y hemos llamado a la funcion printBook, en vez de hacer un printf para que imprima el libro completo, funcion que hemos hecho arriba, con todos los printf de todas las propiedades del libro.
            printBook(&catalogo[i]);
            
            

        }
}
}


void printAllBooks (const Libro * puntero_al_primer_libro_del_catalogo){
        for(int i = 0;i < CAT_MAX; i++){
                printBook(puntero_al_primer_libro_del_catalogo+i);//ponemos un +i para que vaya sumando cada vez, una vez i, y que vaya imprimiendo cada vez el libro siguiente
        }                                                         //Para no tener que ir repitiendo todo el rato todos los libros lo hacemos en un bucle
}
        

void libroPorCategoria(const Libro * catalogo, int categoria){ //Para buscar por la categoría                                               
       
        printf("Libros de categoria %d\n", categoria); //Bucle que recorre todos los libros, y cuando encuentra un libro de la categoria que hemos puesto, imprime ese libro
        for(int i = 0; i < CAT_MAX; i++){
            if(catalogo[i].categoria == categoria){
                            //Cuando encuentra los libros de esa categoria, imprime los libros de esa categoría
                printBook(&catalogo[i]);
            }

        }


}


void IncrementarStock(Libro * stock_libro, int id, int cantidad){ //Aqui no se podría poner const Libro porque se está modificando el libro, entonces me daría un warning

        for(int i = 0; i < CAT_MAX; i++){//Bucle que recorre todos el catalogo hasta encontrar el libros que le hemos introducido
            if (/*id del libro i == id introducido por el scanf*/stock_libro[i].id == id){

                stock_libro[i].cantidad += cantidad;//Para que se le sume a la cantidad de stock la cantidad agregada por el usuario
                printf("El libro ha sido actualizado, la nueva cantidad en stock es: %d\n", stock_libro[i].cantidad);//actualizamos stock



            }
    
    }
}


int main(int argc, char ** argv){ //int main(int argc, char ** argv){}...
            //argc: número de argumentos recibidos
            //argv: array de cadenas de texto

        int numero_libros, id, menu;

        /*char palabra[10] = "Hola";
        printf("%c\n",*(palabra+1));*/

        Libro libros [40] = { //array de los libros

        {1, "To Kill a Mockingbird", "Harper Lee", 15.99,FICCION, 10},
        {2, "1984", "George Orwell", 12.49,FICCION, 5},
        {3, "The Great Gatsby", "F. Scott Fitzgerald", 10.99,FICCION, 8},
        {4, "Moby Dick", "Herman Melville", 18.99,FICCION, 12},
        {5, "War and Peace", "Leo Tolstoy", 20.00,FICCION, 7},
        {6, "Pride and Prejudice", "Jane Austen", 14.99,FICCION, 9},
        {7, "The Catcher in the Rye", "J.D. Salinger", 10.00,FICCION, 6},
        {8, "The Odyssey", "Homer", 17.49,FICCION, 4},
        {9, "Ulysses", "James Joyce", 25.00,FICCION, 2},
        {10, "The Divine Comedy", "Dante Alighieri", 22.00, POESIA, 3},
        {11, "Leaves of Grass", "Walt Whitman", 13.00, POESIA, 11},
        {12, "The Iliad", "Homer", 18.50,FICCION, 7},
        {13, "A Brief History of Time", "Stephen Hawking", 15.00, NO_FICCION, 15},
        {14, "The Art of War", "Sun Tzu", 9.99, NO_FICCION, 20},
        {15, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 16.49, NO_FICCION, 13},
        {16, "The Selfish Gene", "Richard Dawkins", 14.00, NO_FICCION, 6},
        {17, "The Road to Serfdom", "F.A. Hayek", 10.50, NO_FICCION, 5},
        {18, "The Wealth of Nations", "Adam Smith", 30.00, NO_FICCION, 8},
        {19, "On the Origin of Species", "Charles Darwin", 24.99, NO_FICCION, 4},
        {20, "The Prince", "Niccolò Machiavelli", 8.99, NO_FICCION, 14},
        {21, "Hamlet", "William Shakespeare", 11.50, TEATRO, 6},
        {22, "Macbeth", "William Shakespeare", 9.50, TEATRO, 8},
        {23, "Othello", "William Shakespeare", 10.99, TEATRO, 7},
        {24, "A Doll's House", "Henrik Ibsen", 12.50, TEATRO, 5},
        {25, "Waiting for Godot", "Samuel Beckett", 13.99, TEATRO, 4},
        {26, "Death of a Salesman", "Arthur Miller", 14.99, TEATRO, 10},
        {27, "The Glass Menagerie", "Tennessee Williams", 11.00, TEATRO, 9},
        {28, "Long Day's Journey into Night", "Eugene O'Neill", 19.50, TEATRO, 3},
        {29, "The Importance of Being Earnest", "Oscar Wilde", 8.50, TEATRO, 15},
        {30, "The Waste Land", "T.S. Eliot", 6.99, POESIA, 10},
        {31, "Paradise Lost", "John Milton", 12.00, POESIA, 7},
        {32, "Beowulf", "Anonymous", 15.00, POESIA, 5},
        {33, "Essays", "Michel de Montaigne", 20.00, ENSAYO, 4},
        {34, "Self-Reliance and Other Essays", "Ralph Waldo Emerson", 9.00, ENSAYO, 9},
        {35, "Civil Disobedience and Other Essays", "Henry David Thoreau", 7.50, ENSAYO, 11},
        {36, "Meditations", "Marcus Aurelius", 11.99, ENSAYO, 8},
        {37, "The Federalist Papers", "Alexander Hamilton, James Madison, John Jay", 18.00, ENSAYO, 5},
        {38, "The Communist Manifesto", "Karl Marx and Friedrich Engels", 5.99, ENSAYO, 12},
        {39, "The Republic", "Plato", 16.00, ENSAYO, 6},
        {40, "Thus Spoke Zarathustra", "Friedrich Nietzsche", 14.99, ENSAYO, 10}
        };
 


printf("Lista de argumentos (hay %d argumentos):\n",argc);
    for(int i = 0; i<argc; i++){
        printf("\t Argumento %d: %s\n",i,argv[i]);
    }



if (argc == 1){
    printf("Error, pon argumentos\n. ;)");
    }

else if (argc == 2){
    if (strcmp(argv[1], "mostrar") == 0){
        printAllBooks(libros);
    } else if(strcmp(argv[1],"añadir")== 0){
   
        printf("Llamar a añadir el libro 41\n");
    
    }
} else if (argc == 3){

    if (strcmp(argv[1], "mostrar")== 0)
    {
        int id = atoi(argv[2]);
        libroPorId(id,libros);
    } else if (strcmp(argv[1], "autor")== 0)
    {
        printf("Llamar a buscar por autor\n");
    }
    else if (strcmp(argv[1], "categoria")== 0)
    {
        int categoria = atoi(argv[2]);
        libroPorCategoria(libros,categoria);
    }
}else if (argc == 4){
    int id = atoi(argv[2]);
    int cantidad = atoi(argv[3]);
    IncrementarStock(libros,id,cantidad);
}


return 0;
}

 