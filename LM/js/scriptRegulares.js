function isEmail(correo){
    const regex=/^[a-zA-Z0-9._]+@[a-zA-Z]\.[a-z]{2,3}/;

    if(regex.test(correo)){
        return true;
    }else{
        return false;
    }
}

function isTelephone(telefono){
    let regex = /^\d{2}-\d{3}-\d{2}-\d{2}-\d{2}$/;
    if(regex.test(telefono)&&(telefono.length==10)){
        return true;
    }else{
        return false;
    }
}

function contienePalabra(frase){
    let palabra= "hola";
    let partes=frase.split(palabra);
    return partes.length()-1;

}

function reemplazarPalabra(palabra, reemplazo, frase){
    return frase.replace(new RegExp(palabra, "gi"), reemplazo);
}

function isPasswordCorrect(password){
    let regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$/;

    if(regex.test(password)){
        return true;
    }else{
        return false;
    }

}

function exp1(){
    //1. Empiece por A mayuscula y minuscula
    //let expReg=/^[A|a]/;
    //2. Cadena que termine por o
    //Let expReg = /o$/
    //3. Limite de palabra \b iniciar y finalizar

    //\bhola\b Fulanito, hola como estas //true
    //\B\B es lo contrario de \b
/*
    let expReg=/\Bhola\B/;//no limite de palabra, hola debe estar rodeado de caracteres 123hola123
    let palabra = "Fulanito, hola como estas";

*/

/*  let expReg = /[A-Za-z]+/;
    let palabra = "Fulanito hola como estas";
*/
    
/*  let expReg = /[0-9]{2}/;
    let palabra = "123";
*/

/*    let expReg = /\b[0-9]{2}\b/; //\b\d{2}\b\
    //Conocemos el numero de veces {2}
    //Rango {2,4}
    //A partir de {2, }
*/

/*  let expReg = /\b[0-9]{2},[0-9]{2}, [0-9]{4}\b/;
    let palabra = "23,01, 2008";
*/
/*
    function isFecha(fecha){
    
    const regex = /^\d{2}, 0[1-9]|1[0|1|2]], \d{4}$/;

    if (regex.test(fecha)){
        return true;
    }else{
        return false;
    
        }
    }

    let FechaPorPartes=fecha.split(",");
    let day = parseInt(FechaPorPartes[0]);
    let month = parseInt(FechaPorPartes[1]);
    let year = parseInt(FechaPorPartes[2]);
  //creamos el objeto de la fecha
    let fechaIntroducieda= new Date(day, month, year);
//fecha actual
let fecha = new Date();

//la diferencia la devuelve en milisegundos
let diferencia = fechaActual.getTime - fechaIntroducida.getTime;

let diasTranscurridos=Math.round(diferencia / (1000*60*60*24))

alert(diasTranscurridos);

}else {
    docu write formato no correcto + fecha
}
    /\b[A-Za-z0-9._%&]+\@[A-Za-z0-9]+\.[A-Za-z]{2,3}\b/;
    fecha = /^(0[1-9]|[1-2][0-9]|3[0-1], (0[1-9]|1[0-2]), (19|20\d{2})$/;

*/

//ejercicio 2
/*
    let palabra = prompt("correo:");
    let expReg = /\b[A-Za-z0-9._%&$]+\@[A-Za-z0-9]+\.[A-Za-z]{2,3}\b/;
*/


    let palabra = prompt("tfno:");
    let expReg = /[0-9]{2}\- [0-9]{3}\-[0-9]{2}\-[0-9]{2}\-[0-9]{2}/;

    if(expReg.test(palabra)){
        document.writeln("<h2>True -->"+palabra+ "</h2>");
    }else {
        document.writeln("<h2>False -->"+palabra+"</h2>");
    }
    
}
function load(){
    exp1();
    contienePalabra();
    isPasswordCorrect(password);
}
window.addEventListener("DOMContentLoaded", load, false);