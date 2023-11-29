package com.alcadiosystem.m3.models

sealed class ItemsPrincipal(
    var image:Int?,
    var title:String,
    var details:String
){
    object ItemPrincipal1:ItemsPrincipal(
        image = null,
        title = "Cuentas",
        details = "Detalle de la cuenta"
    )
    object ItemPrincipal2:ItemsPrincipal(
        image = null,
        title = "Tarjetas de credito",
        details = "Detalle de la tarjeta"
    )
    object ItemPrincipal3:ItemsPrincipal(
        image = null,
        title = "Recompensas",
        details = "Detalle de la recompensa"
    )
    object ItemPrincipal4:ItemsPrincipal(
        image = null,
        title = "Inversiones",
        details = "Detalle de la inversion"
    )
    object ItemPrincipal5:ItemsPrincipal(
        image = null,
        title = "Creditos",
        details = "Detalle del credito"
    )
}
