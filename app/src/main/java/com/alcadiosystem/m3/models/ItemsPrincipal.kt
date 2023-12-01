package com.alcadiosystem.m3.models

import com.alcadiosystem.m3.navigation.NavScreen

sealed class ItemsPrincipal(
    var image:Int?,
    var title:String,
    var details:String,
    var ruta:String?
){
    object ItemPrincipal1:ItemsPrincipal(
        image = null,
        title = "Cuentas",
        details = "Detalle de la cuenta",
        ruta = NavScreen.MovimientosTabs.name
    )
    object ItemPrincipal2:ItemsPrincipal(
        image = null,
        title = "Tarjetas de credito",
        details = "Detalle de la tarjeta",
        ruta = null
    )
    object ItemPrincipal3:ItemsPrincipal(
        image = null,
        title = "Recompensas",
        details = "Detalle de la recompensa",
        ruta = null
    )
    object ItemPrincipal4:ItemsPrincipal(
        image = null,
        title = "Inversiones",
        details = "Detalle de la inversion",
        ruta = null
    )
    object ItemPrincipal5:ItemsPrincipal(
        image = null,
        title = "Creditos",
        details = "Detalle del credito",
        ruta = null
    )
}
