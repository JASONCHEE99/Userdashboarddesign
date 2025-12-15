package com.dashboard.feature.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.dashboard.core.ui.components.AppScaffold
import com.dashboard.core.ui.components.AppTopBar

@Composable
fun SettingsRoute(navController: NavController) {
    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Settings",
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            SettingsScreen()
        }
    }
}
