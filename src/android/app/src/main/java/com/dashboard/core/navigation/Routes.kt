package com.dashboard.core.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Projects : Routes("projects")
    object Analytics : Routes("analytics")
    object Settings : Routes("settings")
}
