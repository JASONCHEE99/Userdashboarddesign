package com.dashboard.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dashboard.core.ui.components.AppCard
import com.dashboard.core.ui.components.LoadingIndicator
import com.dashboard.core.ui.theme.Dimens
import com.dashboard.core.ui.theme.Gray600
import com.dashboard.core.ui.theme.InfoLight
import com.dashboard.core.ui.theme.Primary
import com.dashboard.core.ui.theme.SuccessLight
import com.dashboard.core.ui.theme.Success

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    if (uiState.isLoading) {
        LoadingIndicator(fullScreen = true)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(Dimens.space24),
            verticalArrangement = Arrangement.spacedBy(Dimens.space24)
        ) {
            // Welcome Section
            Column(verticalArrangement = Arrangement.spacedBy(Dimens.space8)) {
                Text(
                    text = uiState.welcomeMessage,
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "Here's what's happening with your projects today.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Gray600
                )
            }
            
            // Stats Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dimens.space16)
            ) {
                val icons = listOf(
                    Icons.Default.TrendingUp,
                    Icons.Default.People,
                    Icons.Default.TrendingUp,
                    Icons.Default.EmojiEvents
                )
                
                uiState.stats.forEachIndexed { index, stat ->
                    StatCard(
                        stat = stat,
                        icon = icons.getOrNull(index) ?: Icons.Default.TrendingUp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            
            // Quick Actions
            AppCard {
                Text(
                    text = "Quick Actions",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(Dimens.space16))
                Text(
                    text = "Your action items will appear here",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Gray600
                )
            }
        }
    }
}

@Composable
private fun StatCard(
    stat: StatItem,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    AppCard(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(InfoLight, RoundedCornerShape(Dimens.radiusMedium)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.size(Dimens.iconMedium)
                )
            }
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimens.space4),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(SuccessLight, RoundedCornerShape(Dimens.radiusSmall))
                    .padding(horizontal = Dimens.space8, vertical = Dimens.space4)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowUpward,
                    contentDescription = null,
                    tint = Success,
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = stat.change,
                    style = MaterialTheme.typography.labelSmall,
                    color = Success
                )
            }
        }
        
        Spacer(modifier = Modifier.height(Dimens.space12))
        
        Text(
            text = stat.label,
            style = MaterialTheme.typography.bodySmall,
            color = Gray600
        )
        
        Text(
            text = stat.value,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
