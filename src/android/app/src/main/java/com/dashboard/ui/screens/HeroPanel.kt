package com.dashboard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AchievementStat(
    val label: String,
    val value: String,
    val change: String,
    val icon: ImageVector,
    val iconBackgroundColor: Color,
    val iconTintColor: Color
)

@Composable
fun HeroPanel(modifier: Modifier = Modifier) {
    val achievements = listOf(
        AchievementStat(
            "Total Revenue",
            "$86.4K",
            "+12.5%",
            Icons.Default.TrendingUp,
            Color(0xFFDBEAFE),
            Color(0xFF2563EB)
        ),
        AchievementStat(
            "Active Users",
            "2,520",
            "+8.2%",
            Icons.Default.People,
            Color(0xFFF3E8FF),
            Color(0xFF9333EA)
        ),
        AchievementStat(
            "Conversion Rate",
            "3.42%",
            "+2.1%",
            Icons.Default.Adjust,
            Color(0xFFDCFCE7),
            Color(0xFF15803D)
        ),
        AchievementStat(
            "Achievements",
            "127",
            "+15",
            Icons.Default.EmojiEvents,
            Color(0xFFFED7AA),
            Color(0xFFEA580C)
        )
    )
    
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Header
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "Welcome back, John!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF111827)
                )
                Text(
                    text = "Here's what's happening with your projects today.",
                    fontSize = 14.sp,
                    color = Color(0xFF6B7280)
                )
            }
            
            // Achievement Stats Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                achievements.forEach { stat ->
                    AchievementCard(
                        stat = stat,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            
            // Charts Placeholder
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ChartPlaceholder(
                    title = "Revenue Trend",
                    modifier = Modifier.weight(1f)
                )
                ChartPlaceholder(
                    title = "User Growth",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun AchievementCard(
    stat: AchievementStat,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color(0xFFF9FAFB), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(stat.iconBackgroundColor, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = stat.icon,
                        contentDescription = stat.label,
                        tint = stat.iconTintColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
                
                Text(
                    text = stat.change,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF15803D),
                    modifier = Modifier
                        .background(Color(0xFFDCFCE7), RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            
            Text(
                text = stat.label,
                fontSize = 14.sp,
                color = Color(0xFF6B7280)
            )
            
            Text(
                text = stat.value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF111827)
            )
        }
    }
}

@Composable
private fun ChartPlaceholder(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF111827)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(Color(0xFFF9FAFB), RoundedCornerShape(8.dp))
                .border(2.dp, Color(0xFFE5E7EB), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Chart: $title",
                color = Color(0xFF9CA3AF),
                fontSize = 14.sp
            )
        }
    }
}
