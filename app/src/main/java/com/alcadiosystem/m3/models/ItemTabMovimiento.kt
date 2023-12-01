package com.alcadiosystem.m3.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Score
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Score
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.alcadiosystem.m3.screens.movimientos.Egresos
import com.alcadiosystem.m3.screens.movimientos.Ingresos
import com.alcadiosystem.m3.screens.movimientos.Todos

sealed class ItemTabMovimiento(
    var title:String,
    var iconSelected:ImageVector,
    var iconUnselected: ImageVector,
    var screen:@Composable ()->Unit
){
    object tabIngresos:ItemTabMovimiento(
        title = "Ingresos",
        iconSelected = Icons.Filled.EmojiEmotions,
        iconUnselected = Icons.Outlined.EmojiEmotions,
        screen = { Ingresos()}
    )
    object tabEgresos:ItemTabMovimiento(
        title = "Egresos",
        iconSelected = Icons.Filled.Score,
        iconUnselected = Icons.Outlined.Score,
        screen = { Egresos() }
    )
    object tabTodos:ItemTabMovimiento(
        title = "Todos",
        iconSelected = Icons.Filled.MonetizationOn,
        iconUnselected = Icons.Outlined.MonetizationOn,
        screen = { Todos() }
    )
}
