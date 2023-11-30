package com.alcadiosystem.m3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alcadiosystem.m3.component.MenuLateral
import com.alcadiosystem.m3.component.NavegacionInferior
import com.alcadiosystem.m3.component.TopBar
import com.alcadiosystem.m3.models.ItemOptionConfig.*
import com.alcadiosystem.m3.navigation.BancoNavigation
import com.alcadiosystem.m3.ui.theme.M3Theme
import com.alcadiosystem.m3.viewmodel.MainViewModel
import kotlinx.coroutines.launch

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
) {
    val mainViewModel: MainViewModel = viewModel()
    val sheetState = rememberModalBottomSheetState()
    Scaffold(
        bottomBar = {
            NavegacionInferior(navController = navController)
        },
        topBar = {
            TopBar(drawerState = drawerState)
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            BancoNavigation(navController = navController)
        }

    }
    if (mainViewModel.showBottomSheet) {
        ModalBottomSheet(onDismissRequest = { mainViewModel.showBottomSheet = false }) {
            ContentBottomSheet(mainViewModel, navController, sheetState)
        }
    }

    if (mainViewModel.showDialogRecompensas) {
        DialogoRecompensas(mainViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogoRecompensas(mainViewModel: MainViewModel) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Outlined.CardGiftcard,
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        },
        title = { Text(text = "Recompensas") },
        text = { Text(text = "Esta opcion estara disponible muy pronto") },
        onDismissRequest = {
            mainViewModel.showDialogRecompensas = !mainViewModel.showDialogRecompensas
        },
        confirmButton = {
            TextButton(onClick = {
                mainViewModel.showDialogRecompensas = !mainViewModel.showDialogRecompensas
            }) {
                Text(text = "Cerrar")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentBottomSheet(
    mainViewModel: MainViewModel,
    navController: NavHostController,
    sheetState: SheetState
) {

    val scope = rememberCoroutineScope()

    val itemConfiguration = listOf(
        ItemConfig1,
        ItemConfig2
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(horizontal = 28.dp)
    ) {
        Text(text = "Configuracion", style = MaterialTheme.typography.titleLarge)
        itemConfiguration.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(48.dp)
                    .clickable {
                        scope
                            .launch {
                                sheetState.hide()
                            }
                            .invokeOnCompletion {
                                mainViewModel.showBottomSheet = false
                            }
                        navController.navigate(item.ruta)
                    }) {
                Icon(imageVector = item.icon, contentDescription = item.title)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item.title, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}



