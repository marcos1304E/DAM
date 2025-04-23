function random(number){
    return Math.floor(Math.random()*(number+1))
}

function cambiarFondo(){
    document.body.style.background= `rgb(${random(255)}, ${random(255)}, ${random(255)})`;

}

function cambiarTexto(){
    document.body.innerHTML = "<h1>Hola Mundo</h1>";
}

function mostrarDatos(){
    event.preventDefault();
    let nombre = document.getElementById("nombre").value;
    document.getElementById("resultado").innerHTML = `valor: ${nombre}`;
}

function load(){
    let boton = document.querySelector("button");
    let boton2 = document.getElementById("boton2");
    let boton3 = document.getElementById("boton3");
    let cuadroTexto = document.getElementById("cuadroTexto");
    let zona = document.getElementById("zona");
    let formulario=document.getElementById("formulario");

//Eventos
    boton.addEventListener("click", cambiarFondo, false);
    boton2.addEventListener("click", cambiarTexto, false);
    boton3.addEventListener("click", (event) => console.log(event));
    cuadroTexto.addEventListener("keydown", (event) => (document.getElementById("textoSalida").textContent+= `${event.key}`));
    zona.addEventListener ("mousemove", (event) => (document.getElementById("coordenadas").textContent=`Coordenadas: X= ${event.clientX} Y= ${event.clientY}`));
    formulario.addEventListener("submit", mostrarDatos);

}

window.addEventListener("DOMContentLoaded", load, false);