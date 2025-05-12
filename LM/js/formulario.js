document.getElementById('calcular').addEventListener('click', () => {
    const precio = parseFloat(document.getElementById('precio').value);
    const descuento = parseFloat(document.getElementById('descuento').value);
    const resultadoField = document.getElementById('resultado');

    // Validar que el descuento esté entre 0 y 100
    if (descuento < 0 || descuento > 100) {
        alert('El descuento debe estar entre 0 y 100.');
        return;
    }

    // Calcular el precio con descuento
    const resultado = precio - (precio * (descuento / 100));
    resultadoField.value = resultado.toFixed(2); // Mostrar con 2 decimales
});
