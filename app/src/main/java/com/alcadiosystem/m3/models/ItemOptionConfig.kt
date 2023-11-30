package com.alcadiosystem.m3.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.alcadiosystem.m3.navigation.NavScreen

sealed class ItemOptionConfig(
    val icon:ImageVector,
    val title: String,
    val ruta:String
) {
    object ItemConfig1:ItemOptionConfig(
        icon = Icons.Outlined.DarkMode,
        title = "Apariencia",
        ruta = NavScreen.ConfigurarApariencia.name
    )

    object ItemConfig2:ItemOptionConfig(
        icon = Icons.Outlined.Notifications,
        title = "Notificaciones",
        ruta = NavScreen.ConfiguracionNotificacion.name
    )
}