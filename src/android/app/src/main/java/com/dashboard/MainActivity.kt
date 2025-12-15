package com.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.dashboard.core.navigation.AppNavGraph
import com.dashboard.core.ui.theme.DashboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashboardTheme {
                DashboardApp()
            }
        }
    }
}

@Composable
fun DashboardApp() {
    val navController = rememberNavController()
    AppNavGraph(navController = navController)
}