function Ejercicio1(){
    alert("Hola Mundo");
}

function Ejercicio2(){
    document.writeln("Hello, World!" + "<br>");
}

function Ejercicio3(){
    let a = 3;
    let b = 5;
    let suma = a + b;
    document.writeln("La suma de 3 + 5 es: " + suma + "<br>");
}

function Ejercicio4(){
    let nombre = prompt("Ingrese su nombre: ");
    document.writeln("Hola "  + nombre);    
}

function Ejercicio5(){
    let numero = prompt("Ingrese un numero: ");
    let numero2 = prompt("Ingrese otro numero: ");
    let resultado = parseInt(numero) + parseInt(numero2);
    document.writeln("La suma de los numeros es: " + resultado + "<br>");

}

function Ejercicio6(){
    let numero = parseInt(prompt("Ingrese un numero: "));
    let numero2 = parseInt(prompt("Ingrese otro numero: "));
    if (numero > numero2){
        document.writeln("El numero " + numero + " es mayor que " + numero2 + "<br>");
}
    else if (numero < numero2){
        document.writeln("El numero " + numero2 + " es mayor que " + numero + "<br>");
    }
    else{
        document.writeln("Los numeros son iguales" + "<br>");
    }
}

function Ejercicio7(){
    let numero1 = parseInt(prompt("Ingrese un numero: "));
    let numero2 = parseInt(prompt("Ingrese otro numero: "));
    let numero3 = parseInt(prompt("Ingrese un tercer numero: "));

    if (numero1 > numero2) {
        if (numero1 > numero3) {
            if (numero2 > numero3) {
                document.writeln("El orden es: " + numero1 + ", " + numero2 + ", " + numero3 + "<br>");
            } else {
                document.writeln("El orden es: " + numero1 + ", " + numero3 + ", " + numero2 + "<br>");
            }
        } else {
            document.writeln("El orden es: " + numero3 + ", " + numero1 + ", " + numero2 + "<br>");
        }
    } else {
        if (numero2 > numero3) {
            if (numero1 > numero3) {
                document.writeln("El orden es: " + numero2 + ", " + numero1 + ", " + numero3 + "<br>");
            } else {
                document.writeln("El orden es: " + numero2 + ", " + numero3 + ", " + numero1 + "<br>");
            }
        } else {
            document.writeln("El orden es: " + numero3 + ", " + numero2 + ", " + numero1 + "<br>");
        }
    }
}

function Ejercicio8(){
    let numero = parseInt(prompt("Ingrese un numero: "));
    if (numero % 2 == 0){
        document.writeln("Es divisible por 2" + "<br>");
    }
    else{
        document.writeln("No es divisible por 2" + "<br>");
    }
}

function Ejercicio9(){
    let frase = prompt("Ingrese una frase: ");
    let contador = 0;

    for(let i = 0; i < frase.length; i++){
        if (frase[i].toLowerCase() == "a"){
            contador++;
        }
    }
}
//O frase.charAt(i)

function Ejercicio9A(){//la misma funcion pero utilizando split
    let frase = prompt("Ingrese una frase: ");
    let contador = frase.split("a").length - 1;
}   

function EjemploSplit(){//ejemplo de split
    let frase = prompt("Ingrese una frase: ");
    let palabras=frase.split(" ");//separa la frase en palabras
    for(let i=0;i<palabras.length;i++){//recorre las palabras
        document.writeln(palabras[i]+"<br>");//imprime las palabras
    }
    let veces= frase.split(" ").length-1;//cuenta las palabras
    document.writeln(veces);
}

function EjercicioAB(){
    let frase = prompt("Ingrese una frase: ");
    let letra = "a";
    let contador = 0;
    for(let i = 0; i < frase.length; i++){
        if(frase.includes(letra)){
            contador++;
        }
    }
    document.writeln("La cantidad de letras 'a' es: " + contador + "<br>");
    

}
function Ejercicio9C(){
    let frase = prompt("Ingrese una frase: ");
    let contador = 0;
    for (let char of frase){
        if (char.toLowerCase() === "a"){
            contador++;
        }
    }
    document.writeln("La cantidad de letras 'a' es: " + contador + "<br>");
}

function Ejercicio10(){
    let frase = prompt("Ingrese una frase: ");
    let vocales = "aeiouAEIOU";
    let vocalesEncontradas = "";
    for(let char of frase){
        if (vocales.includes(char)){
            if(!vocalesEncontradas.includes(char)){
                vocalesEncontradas += char;

            }
        }    
    }
    document.writeln("Las vocales encontradas son: " + vocalesEncontradas + "<br>");
}

function Ejercicio11(){
    let frase = prompt("Ingrese una frase: ");
    let vocales = "aeiouAEIOU";
    let vocalesEncontradas = "";
    let contador = 0;
    for(let char of frase){
        if (vocales.includes(char)){
            if(!vocalesEncontradas.includes(char)){
                vocalesEncontradas += char;

            }
            contador++;
            
        }    
    }
    document.writeln("La cantidad de vocales es: " + contador + "<br>");
    document.writeln("Las vocales encontradas son: " + vocalesEncontradas + "<br>");
}

function Ejercicio12(){
    let frase = prompt("Ingrese una frase: ");
    let vocales = "aeiouAEIOU";
    let vocalesEncontradas = {a:0,e:0,i:0,o:0,u:0};
    
    for(let char of frase){
        if (vocales.includes(char.toLowerCase())){
            vocalesEncontradas[char.toLowerCase()]++;
        }    
    } 
    document.writeln("La cantidad de vocales a es: " + JSON.stringify(vocalesEncontradas) + "<br>");
}

function Ejercicio14(){//array dinamico
    let num = parseInt (prompt("Ingrese un numero: "));
    let divisibles = []; 
    
    if (num % 2 === 0) divisibles.push("2");
    if (num % 3 === 0) divisibles.push("3");
    if (num % 5 === 0) divisibles.push("5");
    if (num % 7 === 0) divisibles.push("7");

    if (divisibles.length > 0){
        document.writeln(divisibles.join(", "));
    } else {
        document.writeln("No hay divisores");
    }
}



function EjercicioMiau(){//funcion que cuenta las veces que aparece la letra a en una frase
    let frase = prompt("Ingrese una frase: ");
    let contador = 0;
   
    for (let i = 0; i < frase.length; i++){
    if (frase[i].includes("a")){
       contador++;
       console.log(contador);
    }
}
}
function EjercicioGuau(){
    let frase = prompt("Ingrese una frase: ");
    let espacios = frase.split("a");//si pongo hola me llamo marcos sería, [hol, me ll, mo m, rcos], hay 4 elementos, con el -1 se queda en 3, que es la cantidad de letras a
    let contador = espacios.length - 1;

    console.log("La frase tiene " + contador + " letras a");
  
}
function carga(){//funcion  que llama a todas las funciones y funciona como el main del programa
  /*  Ejercicio1();
    Ejercicio2();
    Ejercicio3();
    Ejercicio4();
    Ejercicio5();
    Ejercicio6();
    Ejercicio7();
    Ejercicio8();
    Ejercicio9();
    Ejercicio9A();
    Ejercicio10();
    Ejercicio11();
    Ejercicio12();
    Ejercicio13();
    Ejercicio14();
    Ejercicio15();
    Ejercicio16();
    Ejercicio17();
    EjemploSplit();
<<<<<<< HEAD
    */
    //EjercicioMiau();
    EjercicioGuau();
    
}
=======
    EjercicioAB();
 
    Ejercicio9C();   
    Ejercicio10();
   Ejercicio11();
   Ejercicio12();
  */  Ejercicio14();
   }
>>>>>>> e6daf1d9965b845f1060aecd5a04fc3c2712b50d
    
window.addEventListener("DOMContentLoaded",carga);//llamada a la funcion carga cuando se carga la pagina