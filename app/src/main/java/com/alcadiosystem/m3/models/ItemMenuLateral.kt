package com.alcadiosystem.m3.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.ui.graphics.vector.ImageVector
import com.alcadiosystem.m3.navigation.NavScreen

sealed class ItemMenuLateral(
    val icon:ImageVector,
    val title:String,
    val ruta:String
){
    object ItemMenuLateral1:ItemMenuLateral(
        icon = Icons.Outlined.RealEstateAgent,
        title = "Consulta de saldos",
        ruta = NavScreen.HomeScreen.name
    )

    object ItemMenuLateral2:ItemMenuLateral(
        icon = Icons.Outlined.CreditCard,
        title = "Pagar tarjetas",
        ruta = NavScreen.PagarTarjetas.name
    )

    object ItemMenuLateral3:ItemMenuLateral(
        icon = Icons.Outlined.PriceCheck,
        title = "Pagar servicios",
        ruta = NavScreen.PagarServicios.name
    )

    object ItemMenuLateral4:ItemMenuLateral(
        icon = Icons.Outlined.AttachMoney,
        title = "Transferencias",
        ruta = NavScreen.Transferencias.name
    )
}
