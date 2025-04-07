function random(number){
    return Math.floor(Math.random()*(number+1))
}

function cambiarFondo(){
    document.body.style.background= `rgb(${random(255)}, ${random(255)}, ${random(255)})`;

}

function cambiarTexto(){
    document.body.innerHTML = "<h1>Hola Mundo</h1>";
}
function load(){
    let boton = document.querySelector("button");
    let boton2 = document.getElementById("boton2");
    let cuadroTexto = document.getElementById("cuadroTexto");

//Eventos
    boton.addEventListener("click", cambiarFondo, false);
    boton2.addEventListener("click", cambiarTexto, false);
    cuadroTexto.addEventListener("keydown", (event) => ());
}

window.addEventListener("DOMContentLoaded", load, false);