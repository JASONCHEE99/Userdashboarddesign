package com.dashboard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.ShoppingCart
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

data class SummaryCardData(
    val title: String,
    val value: String,
    val change: String,
    val isPositive: Boolean,
    val icon: ImageVector,
    val description: String
)

@Composable
fun SummaryCards(modifier: Modifier = Modifier) {
    val summaryData = listOf(
        SummaryCardData(
            title = "Total Sales",
            value = "$45,231.89",
            change = "+20.1%",
            isPositive = true,
            icon = Icons.Default.AttachMoney,
            description = "from last month"
        ),
        SummaryCardData(
            title = "Orders",
            value = "2,345",
            change = "+12.3%",
            isPositive = true,
            icon = Icons.Default.ShoppingCart,
            description = "from last month"
        ),
        SummaryCardData(
            title = "Active Sessions",
            value = "1,234",
            change = "-4.7%",
            isPositive = false,
            icon = Icons.Default.ShowChart,
            description = "from last hour"
        ),
        SummaryCardData(
            title = "Processing",
            value = "$12,234",
            change = "+8.1%",
            isPositive = true,
            icon = Icons.Default.CreditCard,
            description = "pending payments"
        )
    )
    
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        summaryData.forEach { card ->
            SummaryCard(
                data = card,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun SummaryCard(
    data: SummaryCardData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Icon and Change Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFF3F4F6), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = data.icon,
                        contentDescription = data.title,
                        tint = Color(0xFF374151),
                        modifier = Modifier.size(24.dp)
                    )
                }
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = if (data.isPositive) Color(0xFFDCFCE7) else Color(0xFFFEE2E2),
                            shape = CircleShape
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = if (data.isPositive) Icons.Default.ArrowUpward else Icons.Default.ArrowDownward,
                        contentDescription = if (data.isPositive) "Increase" else "Decrease",
                        tint = if (data.isPositive) Color(0xFF15803D) else Color(0xFF991B1B),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = data.change,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (data.isPositive) Color(0xFF15803D) else Color(0xFF991B1B)
                    )
                }
            }
            
            // Content
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = data.title,
                    fontSize = 14.sp,
                    color = Color(0xFF6B7280)
                )
                Text(
                    text = data.value,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF111827)
                )
                Text(
                    text = data.description,
                    fontSize = 12.sp,
                    color = Color(0xFF9CA3AF)
                )
            }
        }
    }
}
