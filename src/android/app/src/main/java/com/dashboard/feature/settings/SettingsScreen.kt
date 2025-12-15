package com.dashboard.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dashboard.core.ui.components.AppCard
import com.dashboard.core.ui.components.AppListItemWithSwitch
import com.dashboard.core.ui.theme.Dimens
import com.dashboard.core.ui.theme.Gray600

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(Dimens.space24),
        verticalArrangement = Arrangement.spacedBy(Dimens.space24)
    ) {
        // Profile Section
        AppCard {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(Dimens.space12))
            Text(
                text = uiState.username,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = uiState.email,
                style = MaterialTheme.typography.bodyMedium,
                color = Gray600
            )
        }
        
        // Preferences Section
        AppCard {
            Text(
                text = "Preferences",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(Dimens.space16)
            )
            
            AppListItemWithSwitch(
                title = "Notifications",
                subtitle = "Enable push notifications",
                leadingIcon = Icons.Default.Notifications,
                checked = uiState.notificationsEnabled,
                onCheckedChange = { viewModel.toggleNotifications(it) }
            )
            
            AppListItemWithSwitch(
                title = "Dark Mode",
                subtitle = "Switch to dark theme",
                leadingIcon = Icons.Default.DarkMode,
                checked = uiState.darkModeEnabled,
                onCheckedChange = { viewModel.toggleDarkMode(it) }
            )
        }
    }
}
