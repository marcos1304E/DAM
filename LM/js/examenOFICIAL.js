function Gasolinera(){

document.getElementById('calcular').addEventListener ('click', function () {
    
    let matricula = document.getElementById('matricula').value;
    let litros = parseFloat(document.getElementById('litros').value);
    let precioFinal = document.getElementById('precio');
    let precioPorLitro = 1.26;

    const matriculaRegex = /^[A-Z]{3}\d{4}$/;

    if (!matriculaRegex.test(matricula)) {  
        alert('La matrícula debe tener 3 letras seguidas de 4 números, como por ejemplo ABC1234');
        return;
    }
   
    const precioTotal = litros * precioPorLitro;

    precioFinal.value = precioTotal;

});
}



function load(){
    Gasolinera();
}

window.addEventListener("DOMContentLoaded", load);