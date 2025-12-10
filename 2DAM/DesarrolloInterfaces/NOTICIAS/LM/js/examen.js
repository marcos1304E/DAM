let numeroAdivinar = 0;
let veces = 0;
let matriz = [ [0,0,0], [0,0,0], [0,0,0] ];
let intentos = 3;

function random(numero){
    let numeroAleatorio= Math.floor(Math.random() * (numero+1));
    return numeroAleatorio;
}

function generarNumeroAdivinar(){
    numeroAdivinar = random(9);
    document.getElementById("numeroAdivinar").textContent = numeroAdivinar;
    document.getElementById("veces").textContent = veces;
}

function generarVeces(){
    document.getElementById("veces").textContent = veces;
}

function rellenarMatriz(){
    for(let i=0; i<3; i++){
        for(let j=0; j<3; j++){
            matriz[i][j] = random(9);
            if (matriz [i][j] === numeroAdivinar){
                veces++;
            }
        }
    }

    if (veces === 0){
        matriz[random(2)] [random(2)] = numeroAdivinar;
        veces = 1;
    }
}

function comprobarNumero(event){
    let i= event.target.value[0];
    let j= event.target.value[1];

    if(matriz[i][j] === numeroAdivinar){
        document.getElementById(event.target.value).textContent = matriz[i][j]; 
    } else {
        alert("No es el mismo numero");
        console.log(matriz[i][j]);
        event.target.disabled = true;
    }
    document.getElementById("intentos").textContent = intentos--;

}

function principal(){
    generarNumeroAdivinar();
    rellenarMatriz();
    generarVeces();
    let botonesNumeros = document.querySelectorAll(".boton");
    botonesNumeros.forEach(boton => boton.addEventListener("click", comprobarNumero));
}

window.addEventListener("DOMContentLoaded", principal);