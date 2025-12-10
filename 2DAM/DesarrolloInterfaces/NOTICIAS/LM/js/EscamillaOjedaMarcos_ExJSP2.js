/*
Marcos Escamilla Ojeda
*/
function VentanaEmergente(){

    document.getElementById("ventana").addEventListener("click", function () {

    let palabra = prompt("Introduce una palabra de solo letras y hasta 10 caracteres");

    let regex = /^[a-zA-zñ]{1,10}$/;
   

    
    if (!regex.test(palabra)) {
        alert("La palabra tiene que tener solo letras y hasta 10 caracteres");
        return;
    }
    
    document.getElementById("resultadoEjercicio1").textContent = `La palabra es: ${palabra}`;

    });

}

function Fibonacci(){
    
    let resultadoFinal = document.getElementById("resultadoFibonacci");
    
    document.getElementById("botonFibonacci").addEventListener("click", function () {
    

    let a = 0;
    let b = 1;

    let next = a + b;
    a = b;
    next = b;
    
    resultadoFinal.textContent = `Fibonacci: ${next}`;
    
    
    });

}

function load(){
    VentanaEmergente();
    Fibonacci();
    
}
window.addEventListener("DOMContentLoaded", load);