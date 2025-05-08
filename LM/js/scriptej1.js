let input = document.getElementById("texto");
let resultado = document.getElementById("resultado");

let abecedario = "abcdefghijklmnñopqrstuvwxyz";

input.addEventListener("input", function () {
  let texto = input.value.toLowerCase();
  let codificado = "";

  for (let i = 0; i < texto.length; i++) {
    let letra = texto[i];
    let posicion = abecedario.indexOf(letra);
    if (posicion !== -1) {
      codificado += (posicion + 1);
    }
  }

  resultado.textContent = codificado;
});
