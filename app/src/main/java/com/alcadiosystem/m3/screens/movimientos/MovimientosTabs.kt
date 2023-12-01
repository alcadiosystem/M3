package com.alcadiosystem.m3.screens.movimientos

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.alcadiosystem.m3.models.ItemTabMovimiento
import com.alcadiosystem.m3.models.ItemTabMovimiento.tabEgresos
import com.alcadiosystem.m3.models.ItemTabMovimiento.tabIngresos
import com.alcadiosystem.m3.models.ItemTabMovimiento.tabTodos
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovimientosTabs() {
    val tabs = listOf(
        tabIngresos,
        tabEgresos,
        tabTodos
    )

    var pagerState = rememberPagerState {
        tabs.size
    }

    Column {
        Tabs(tabs, pagerState)
        TabsContent(tabs, pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(tabs: List<ItemTabMovimiento>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(tabs: List<ItemTabMovimiento>, pagerState: PagerState) {

    val state = pagerState.currentPage
    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = state) {
        tabs.forEachIndexed { index, item ->
            Tab(
                selected = state == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(text = item.title) },
                icon = {
                    Icon(
                        if(index == state) item.iconSelected
                        else item.iconUnselected
                        ,contentDescription = item.title
                    )
                }
            )
        }
    }
}
