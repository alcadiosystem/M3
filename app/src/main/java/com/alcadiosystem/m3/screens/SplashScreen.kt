package com.alcadiosystem.m3.screens

import android.content.Intent
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alcadiosystem.m3.MainActivity
import com.alcadiosystem.m3.R
import com.alcadiosystem.m3.SplashActivity
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {

    val context = LocalContext.current
    val scala = remember{ Animatable(0f) }

    LaunchedEffect(key1 = true){
        scala.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                }
            )

        )
        delay(1000L)
        val intent = Intent(
            context,
            MainActivity::class.java
        )
        context.startActivity(intent)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.scale(scale = scala.value)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bench),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Bienvenido",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
        OutlinedButton(onClick = {
            val intent = Intent(
                context,
                MainActivity::class.java
            )
            context.startActivity(intent)
        }) {
            Text(text = "Continuar", style = MaterialTheme.typography.bodyLarge)
        }
    }
}