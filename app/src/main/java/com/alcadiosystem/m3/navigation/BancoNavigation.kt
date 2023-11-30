package com.alcadiosystem.m3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alcadiosystem.m3.screens.ConfigurarApariencia
import com.alcadiosystem.m3.screens.ConfigurarNotificaciones
import com.alcadiosystem.m3.screens.HomeScreen
import com.alcadiosystem.m3.screens.PagarServicioScreen
import com.alcadiosystem.m3.screens.TarjetasScreen
import com.alcadiosystem.m3.screens.TransferenciaScreen

@Composable
fun BancoNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavScreen.HomeScreen.name ){
        composable(NavScreen.HomeScreen.name){
            HomeScreen()
        }
        composable(NavScreen.PagarServicios.name){
            PagarServicioScreen()
        }
        composable(NavScreen.PagarTarjetas.name){
            TarjetasScreen()
        }
        composable(NavScreen.Transferencias.name){
            TransferenciaScreen()
        }
        composable(NavScreen.ConfigurarApariencia.name){
            ConfigurarApariencia()
        }
        composable(NavScreen.ConfiguracionNotificacion.name){
            ConfigurarNotificaciones()
        }
    }

}