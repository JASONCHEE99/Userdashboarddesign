package com.dashboard.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dashboard.feature.home.HomeRoute
import com.dashboard.feature.analytics.AnalyticsRoute
import com.dashboard.feature.settings.SettingsRoute

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = Routes.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.Home.route) {
            HomeRoute(navController = navController)
        }
        
        composable(Routes.Analytics.route) {
            AnalyticsRoute(navController = navController)
        }
        
        composable(Routes.Settings.route) {
            SettingsRoute(navController = navController)
        }
    }
}
