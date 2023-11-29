package com.alcadiosystem.m3.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.ui.graphics.vector.ImageVector
import com.alcadiosystem.m3.navigation.NavScreen

sealed class ItemBottomNav(
    val icon:ImageVector,
    val title: String,
    val ruta:String
){
    object ItemBottomNav1:ItemBottomNav(
        icon = Icons.Outlined.AttachMoney,
        title = "Transferencias",
        ruta = NavScreen.Transferencas.name
    )
    object ItemBottomNav2:ItemBottomNav(
        icon = Icons.Outlined.PriceCheck,
        title = "Pagras Servicios",
        ruta = NavScreen.PagarServicios.name
    )
    object ItemBottomNav3:ItemBottomNav(
        icon = Icons.Outlined.CreditCard,
        title = "Tarjetas de credito",
        ruta = NavScreen.PagarTarjetas.name
    )
}
