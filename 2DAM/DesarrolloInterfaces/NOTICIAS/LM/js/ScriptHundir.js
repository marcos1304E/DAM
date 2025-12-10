//donde el indice es el numero de cuadrados que tengo
let barcos = [4, 3, 2, 1];
//tablero del usuario
let tableroUsuario;
//posicion en la cadena que nos devuelve el id -> u01

/*function esBarco2(posicion1, posicion2){
    if (m[i][j] == m[i][j] ){
        
    }
}
*/
function guardarbarco(event){
    alert("guardando barco");
    //u01- 0:u,1:i,2:j
    /*
        <button id = "u01" value= "12"> jhghj</button> --> JS event.target
    */
   //i = event.target.id[0] diferencio si es la matriz del ordenador o del usuario
    let i = event.target.value[1];
    let j = event.target.value[2];
    if (i = event.target.id[0] === 'u'){
        tableroUsuario[i][j] = 'x';
    }
    
    console.log("guardando barco en la posicion: " + i +" "+ j);
    
}

function principal(){
    let celdasTabla = document.querySelectorAll(".celda");
    celdasTabla.forEach(celda =>celda.addEventListener("keydown", guardarbarco));

}

window.addEventListener("DOMContentLoaded", principal);