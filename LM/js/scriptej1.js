const input = document.getElementById("texto");
const resultado = document.getElementById("resultado");

// Abecedario español con la ñ incluida
const abecedario = "abcdefghijklmnñopqrstuvwxyz";

input.addEventListener("input", () => {
  const texto = input.value.toLowerCase();
  let codificado = "";

  for (let letra of texto) {
    const posicion = abecedario.indexOf(letra);
    if (posicion !== -1) {
      codificado += (posicion + 1);
    }
  }

  resultado.textContent = codificado;
});
