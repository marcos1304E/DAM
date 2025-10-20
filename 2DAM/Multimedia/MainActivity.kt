/*package com.example.dia2project

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dia2project.ui.theme.Dia2projectTheme
import java.nio.file.WatchEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlin.random.Random
import androidx.compose.material3.Button




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContent {
           // DosTextosVertical()
           //EjemploBox()
           ImagenConTexto()
       }
    }
}


@Composable
fun DosTextosVertical () {


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp)) {

    Spacer(modifier = Modifier.height(height = 40.dp))
        Row() {
            Text(text = "Segundo Texto")
            Spacer(modifier = Modifier.width(width = 20.dp))
            Text(text = "Tercer Texto")

        }

        Column(modifier = Modifier.fillMaxSize().padding(top = 40.dp)) {

            Text(text = "mi Primer Texto")
            Text(text = "mi Segundo Texto")
        }
       // Spacer(modifier = Modifier.height(height = 30.dp))

    }
}


@Composable
fun EjemploBox(){

    Box(modifier = Modifier.fillMaxSize().padding(20.dp)){
        Text("Parte Superior Izquierda", modifier = Modifier.align(Alignment.TopStart))

        Text("Parte Central", modifier = Modifier.align(Alignment.Center))

        Text("Parte Inferior Derecha", modifier = Modifier.align(Alignment.BottomEnd))

 
    }

}
fun randomColor():Color{

    val rojo = (0.. 255).random()
    val azul = (0 .. 255).random()
    val verde = (0.. 255).random()

}


@Composable
fun ImagenConTexto(){

    Box(modifier = Modifier.fillMaxSize().padding(25.dp).background(backgroundboxColor)){
        Image(
            painter = painterResource(id = R.drawable.images),
            contentDescription = "Tortuga andando",
            modifier = Modifier.align (Alignment.Center).fillMaxSize()
        )

        Text(text = "amai",
        fontSize = 62.sp,
        color = Color.Green,
            textAlign = TextAlign.Center, //modifier = Modifier.align(Alignment.Center)
                modifier = Modifier.offset{
                   // IntOffset((textPosicion.x.toInt(), textPosicion.y.toInt()))
                    IntOffset(textPosicion.x.toInt(), textPosicion.y.toInt())

                }.pointerInput(Unit){
                    detectDragGestures {
                        change,dragAmount ->
                        change.consume()
                        textPosicion = Offset(dragAmount.x, dragAmount.y)
                    }
                }

            )

        Button (
            onClick = { backgroundBoxColor = randomColor()},
            modifier = Modifier.align(Alignment.TopStart)

        )
        {
            Text(text = "Cambiar fondo")
        }
    }
}



@Preview
@Composable
fun DosTextosVerticalPreview(){

    DosTextosVertical()
}


/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dia2projectTheme {
        Greeting("Android")
    }
}
*/
        */
package com.example.dia2project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //DosTextosVertical()
            //EjemploBox()
            //ImagenConTexto()
            ImagenConZoom()
        }
    }
}

@Composable
fun DosTextosVertical() {
    Column() {
        Spacer(modifier = Modifier.height(40.dp))

        Row() {
            Text("Segundo texto")
            Spacer(modifier = Modifier.width(20.dp))
            Text("Tercer texto")
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp)) {
            Text("Primer texto")
            Text("Segundo texto")
        }
    }
}


@Composable
fun EjemploBox(){
    Box(modifier=Modifier.fillMaxSize().padding(25.dp)){
        Text("Parte superior izquierda", modifier = Modifier.align(Alignment.TopStart))

        Text("Parte central", modifier = Modifier.align(Alignment.Center))

        Text("Parte inferior derecha", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun ImagenConTexto() {
    // var porque puede cambiar
    var backgroundBoxColor by remember { mutableStateOf(Color.White) }
    var textPosicion by remember { mutableStateOf(Offset(0f, 0f)) }
    Box(modifier = Modifier.fillMaxSize().padding(25.dp).background(backgroundBoxColor)) {
        Image(
            painter = painterResource(id = R.drawable.tortuga),
            contentDescription = "Tortuga andando",
            modifier = Modifier.align(Alignment.Center).fillMaxSize()
        )

        Text(
            text = "Tortuga andando",
            fontSize = 22.sp,
            color = Color.Green,
            textAlign = TextAlign.Center,
            //modifier=Modifier.align(Alignment.Center)
            modifier = Modifier.offset {
                IntOffset(textPosicion.x.toInt(), textPosicion.y.toInt())
            }.pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->

                    change.consume()
                    textPosicion += Offset(dragAmount.x, dragAmount.y)
                }
            }

        )
    }
}

@Composable
fun ImagenConZoom(){
    var escalaImagen by remember { mutableStateOf(1f) }
    var posicionImagen by remember {mutableStateOf(Offset(0f, 0f))}
    var anguloRotacion by remember { mutableStateOf(0f) }

    Box (

        modifier = Modifier.fillMaxSize().pointerInput(Unit){
            detectTransformGestures {_, desplazamiento, zoom, rotacion  ->
                escalaImagen  *= zoom
                posicionImagen += desplazamiento
                anguloRotacion += rotacion

            }
        }.pointerInput(Unit){
            detectTapGestures(onDoubleTap = {
                escalaImagen = 1f
                posicionImagen = Offset(0f, 0f)
                anguloRotacion = 0f
            })
        }, contentAlignment = Alignment.Center

    )
    {
        Image(
            painter = painterResource(id = R.drawable.tortuga),
            contentDescription = "Tortuga andando",
            modifier = Modifier.graphicsLayer(

                scaleX = escalaImagen.coerceIn(0.5f, 3f),
                scaleY = escalaImagen.coerceIn(0.5f, 3f),
                translationX = posicionImagen.x,
                translationY = posicionImagen.y,
                rotationZ = anguloRotacion

                )
        )
    }


}