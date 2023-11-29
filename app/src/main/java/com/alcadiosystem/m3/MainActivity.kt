package com.alcadiosystem.m3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alcadiosystem.m3.component.MenuLateral
import com.alcadiosystem.m3.component.NavegacionInferior
import com.alcadiosystem.m3.component.TopBar
import com.alcadiosystem.m3.navigation.BancoNavigation
import com.alcadiosystem.m3.ui.theme.M3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    MenuLateral(navController = navController, drawerState = drawerState) {
        Contenido(navController = navController, drawerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contenido(
    navController: NavHostController,
    drawerState: DrawerState
){
    Scaffold(
        bottomBar = {
            NavegacionInferior(navController = navController)
        },
        topBar = {
            TopBar(drawerState = drawerState)
        }
    ) {padding ->
        Box(modifier = Modifier.padding(padding)){
            BancoNavigation(navController = navController)
        }

    }
}



