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
    let letra = 'a';
    let contador = 0;
    for(let i of frase){
        if(frase.includes(letra)){
            contador++;
        }
    }

}

function carga(){//funcion  que llama a todas las funciones y funciona como el main del programa
    Ejercicio1();
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
    
}
    
window.addEventListener("DOMContentLoaded",carga);//llamada a la funcion carga cuando se carga la pagina