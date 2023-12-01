package com.alcadiosystem.m3.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alcadiosystem.m3.models.ItemsPrincipal
import com.alcadiosystem.m3.models.ItemsPrincipal.*
import com.alcadiosystem.m3.navigation.NavScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    val listItemPrincipal = listOf(
        ItemPrincipal1,
        ItemPrincipal2,
        ItemPrincipal3,
        ItemPrincipal4,
        ItemPrincipal5,
    )
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(listItemPrincipal) { item ->
            ListItemRow(item, navController)
            Divider()
        }
    }
}

@Composable
fun ListItemRow(item: ItemsPrincipal, navController: NavHostController) {
    var masInfo = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .animateContentSize(animationSpec = tween(250))
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = {masInfo.value = !masInfo.value}) {
                Icon(
                    if (masInfo.value) {
                        Icons.Rounded.Remove
                    } else {
                        Icons.Rounded.Add
                    },
                    contentDescription = "MAs informacion"
                )
            }
        }
        if(masInfo.value){
            Row(
                modifier = Modifier.clickable {
                    navController.navigate(NavScreen.MovimientosTabs.name)
                }
            ){
                Text(text = item.details)
            }
        }
    }
}
