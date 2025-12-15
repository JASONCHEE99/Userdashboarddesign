package com.dashboard.feature.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dashboard.core.ui.components.AppScaffold
import com.dashboard.core.ui.components.AppTopBar

@Composable
fun HomeRoute(navController: NavController) {
    AppScaffold(
        topBar = {
            AppTopBar(title = "Dashboard")
        }
    ) { paddingValues ->
        androidx.compose.foundation.layout.Box(
            modifier = androidx.compose.ui.Modifier.padding(paddingValues)
        ) {
            HomeScreen()
        }
    }
}
