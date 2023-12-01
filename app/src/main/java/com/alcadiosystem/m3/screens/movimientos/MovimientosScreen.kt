package com.alcadiosystem.m3.screens.movimientos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Score
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Score
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Ingresos() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Outlined.EmojiEmotions,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Text(text = "Ingresos", style = MaterialTheme.typography.titleLarge)
    }
}


@Composable
fun Egresos() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Outlined.Score, contentDescription = null, modifier = Modifier.size(64.dp))
        Text(text = "Egresos", style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun Todos() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Outlined.MonetizationOn,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Text(
            text = "Todos los movimientos",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}