package com.dashboard.feature.analytics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.dashboard.core.ui.components.AppScaffold
import com.dashboard.core.ui.components.AppTopBar

@Composable
fun AnalyticsRoute(navController: NavController) {
    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Analytics",
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Analytics Screen - Coming Soon")
        }
    }
}
