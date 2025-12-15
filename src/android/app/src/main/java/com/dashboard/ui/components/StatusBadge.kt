package com.dashboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dashboard.config.StatusConfig
import com.dashboard.model.StatusType

@Composable
fun StatusBadge(
    status: StatusType,
    modifier: Modifier = Modifier
) {
    val style = StatusConfig.getStatusStyle(status)
    
    Text(
        text = style.label,
        color = style.textColor,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
            .background(
                color = style.backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}
