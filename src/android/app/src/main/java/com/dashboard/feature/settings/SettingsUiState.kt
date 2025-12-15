package com.dashboard.feature.settings

data class SettingsUiState(
    val notificationsEnabled: Boolean = true,
    val darkModeEnabled: Boolean = false,
    val username: String = "John Doe",
    val email: String = "john.doe@example.com"
)
