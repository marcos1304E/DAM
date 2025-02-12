const canvas = document.getElementById("gameCanvas");
const ctx = canvas.getContext("2d");

let score = 0;  // Marcador de goles

// Posición y tamaño de la portería
const goalWidth = 200;
const goalHeight = 100;
const goalX = (canvas.width - goalWidth) / 2;
const goalY = canvas.height - goalHeight - 20;

// Posición y tamaño del portero
const keeperWidth = 50;
const keeperHeight = 70;
let keeperX = (canvas.width - keeperWidth) / 2;  // Empieza en el centro
let keeperDirection = 1;  // 1 es a la derecha, -1 a la izquierda
let keeperSpeed = 3;

// Posición de la pelota
let ballX = canvas.width / 2;
let ballY = canvas.height - 50;
let ballRadius = 10;
let isBallMoving = false;  // Para saber si la pelota ya está en movimiento

// Evento para disparar el balón
canvas.addEventListener("click", shootBall);

// Función para disparar el balón
function shootBall() {
    if (!isBallMoving) {
        isBallMoving = true;
        ballY = canvas.height - 50;  // Reiniciar la posición de la pelota
        let speed = 10;
        let interval = setInterval(() => {
            if (ballY <= goalY && ballX >= goalX && ballX <= goalX + goalWidth) {
                // Gol, la pelota entra en la portería
                score++;
                document.getElementById("score").innerText = score;
                clearInterval(interval);
                isBallMoving = false;
                ballX = canvas.width / 2;  // Volver a centrar la pelota
                ballY = canvas.height - 50;
            } else if (ballY <= 0) {
                // La pelota se fue fuera
                clearInterval(interval);
                isBallMoving = false;
                ballX = canvas.width / 2;  // Volver a centrar la pelota
                ballY = canvas.height - 50;
            } else {
                ballY -= speed;  // Mover la pelota hacia arriba
            }
            drawGame();
        }, 30);
    }
}

// Función para dibujar el portero
function drawKeeper() {
    ctx.fillStyle = "#ff0000";  // Rojo
    ctx.fillRect(keeperX, canvas.height - keeperHeight - 20, keeperWidth, keeperHeight);
}

// Función para mover el portero
function moveKeeper() {
    keeperX += keeperDirection * keeperSpeed;
    if (keeperX <= goalX || keeperX >= goalX + goalWidth - keeperWidth) {
        keeperDirection *= -1;  // Cambiar la dirección cuando llega al límite
    }
}

// Función para dibujar la pelota
function drawBall() {
    ctx.fillStyle = "#0000ff";  // Azul
    ctx.beginPath();
    ctx.arc(ballX, ballY, ballRadius, 0, Math.PI * 2);
    ctx.fill();
}

// Función para dibujar la portería
function drawGoal() {
    ctx.fillStyle = "#ffffff";  // Blanco
    ctx.fillRect(goalX, goalY, goalWidth, goalHeight);
}

// Función para dibujar todo el juego
function drawGame() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);  // Limpiar el canvas

    drawGoal();
    drawKeeper();
    drawBall();
    moveKeeper();  // Mover al portero
}

// Llamar a la función para dibujar el juego constantemente
setInterval(drawGame, 30);
