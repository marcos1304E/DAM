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

function load(){
    let botonNumero = document.getElementById("numeroAleatorio");
        botonNumero.addEventListener("click", () => {
    let numero = Math.floor(Math.random() * 100);
    document.getElementById("mostrarNumero").textContent= numero;
        }
            );

let botonAtras = document.getElementById("cuentaAtras");
    botonAtras.addEventListener("click", cuentaAtras);
}

window.addEventListener("DOMContentLoaded", load, false);