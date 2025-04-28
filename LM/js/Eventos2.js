function cuentaAtras(){
    let cuenta;
    clearInterval(cuenta);

    let valorTiempo = document.getElementById("tiempo").value;
    let contador = document.getElementById("contador");

    cuenta = setInterval(() => {
        if (valorTiempo > 0) {            
            contador.textContent = valorTiempo--;
        } else {
            clearInterval(cuenta);
            contador.textContent = "El tiempo ha expirado";
        }
    }, 1000);
    
}

function rellenarTabla(){
    let numero=9;
    for(let i=1; i<=numero; i++){
      document.getElementById(`${i}`).textContent = i;
    }
}

function rellenarTabla2(){
    let celda = document.querySelectorAll(`#tablaSegunda td`);
    celda.forEach((td,i) => td.textContent=i+1);
    
}

/*function palabras(){
    
    let palabras = ["Hola", "Adios", "Bienvenido", "HastaLuego", "Gracias"];
    let palabraAleatoria = palabras[Math.floor(Math.random() * palabras.length)];
    let contador = 0;
    
}
*/

function ahorcado(event){
    let palabras = ["perro", "gato", "tortuga", "pez", "caiman"];
    let palabrasSeleccionadas = palabras[random(palabras.length)];

    console.log(event.target.textContent);

}


function load(){
            //ej1
    let botonNumero = document.getElementById("numeroAleatorio");
        botonNumero.addEventListener("click", () => {
    let numero = Math.floor(Math.random() * 100);
    document.getElementById("mostrarNumero").textContent= numero;
        }
            );

            //ej2
    let botonAtras = document.getElementById("cuentaAtras");
    botonAtras.addEventListener("click", cuentaAtras);
            //ej3
    document.getElementById("tabla").addEventListener("click", rellenarTabla);
    document.getElementById("tabla2").addEventListener("click", rellenarTabla2);


    let letras = document.querySelectorAll(".ejercicio5");
    letras.forEach(botonesLetras => botonesLetras.addEventListener('click', ahorcado));

}

window.addEventListener("DOMContentLoaded", load, false);