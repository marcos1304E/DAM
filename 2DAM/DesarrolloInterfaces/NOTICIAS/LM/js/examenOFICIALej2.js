function juegoTrileros(){

let posicionBola = Math.floor(Math.random() * 3);

let botones = [document.getElementById('boton1'), document.getElementById('boton2'), document.getElementById('boton3')];

let mensaje = document.getElementById('mensaje');

botones.forEach((boton, posi) => {
    boton.addEventListener('click', () => {

        if (posi === posicionBola) {
            boton.textContent = 'Ahí esta la bola';
            mensaje.textContent = 'victoria';
                  
        } else {
            boton.textContent = 'No está ahi';
            mensaje.textContent = 'prueba otra vez';
            
        }
    });
});

}

function load(){

    juegoTrileros();

}

window.addEventListener("DOMContentLoaded", load); 