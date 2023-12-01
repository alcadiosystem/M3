package com.alcadiosystem.m3.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contactless
import androidx.compose.material.icons.outlined.Contactless
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alcadiosystem.m3.R

@Composable
fun TarjetasScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Image(painter = painterResource(id = R.drawable.ic_debit_card), contentDescription = null)
//        Text(text = "Tarjetas de credito", style = MaterialTheme.typography.titleMedium)
        MostrarTarjeta()
    }
}

@Composable
fun MostrarTarjeta() {
    var rotated by remember { mutableStateOf(false) }
    val rotar by animateFloatAsState(targetValue = if (rotated) 180f else 0f, animationSpec = tween(500))
    Card(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
            .padding(10.dp)
            .graphicsLayer {
                rotationY = rotar
                cameraDistance = 8 * density
            }
            .clickable { rotated = !rotated },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        if (!rotated) TarjetaFrente()
        else TarjetaAtras(rotar)

    }
}

@Composable
fun TarjetaFrente() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Outlined.Contactless,
                contentDescription = null,
                modifier = Modifier.size(54.dp)
            )

            Image(painter = painterResource(id = R.drawable.ic_card), contentDescription = null, modifier = Modifier.size(54.dp))

        }
        Text(text = "1234 5678 90")
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(text = "Titular")
                Text(text = "Jhonny Sierra C.")
            }
            Column {
                Text(text = "Valida hasta")
                Text(text = "23/23")
            }
        }
    }
}

@Composable
fun TarjetaAtras(rotar: Float) {
    Column {
        Divider(
            color = Color.Black,
            thickness = 50.dp
        )
        Text(
            text = "123",
            color = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
                .graphicsLayer {
                    rotationY = rotar
                },
            textAlign = TextAlign.End
        )
    }
}
