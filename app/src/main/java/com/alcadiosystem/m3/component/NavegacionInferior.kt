package com.alcadiosystem.m3.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.alcadiosystem.m3.models.ItemBottomNav.*
import com.alcadiosystem.m3.navigation.CurrentRoute

@Composable
fun NavegacionInferior(
    navController: NavHostController
) {
    val menuItem = listOf(
        ItemBottomNav1,
        ItemBottomNav2,
        ItemBottomNav3,
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.inverseOnSurface
    ) {
        menuItem.forEach {item ->
            val selected = CurrentRoute(navController = navController) == item.ruta
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(item.ruta) },
                label = { Text(text = item.title)},
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) })
        }
    }

}