package com.dashboard.feature.home

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val welcomeMessage: String = "Welcome back, John!",
    val stats: List<StatItem> = emptyList()
)

data class StatItem(
    val label: String,
    val value: String,
    val change: String,
    val isPositive: Boolean
)
