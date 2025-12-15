package com.dashboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressBar(
    progress: Int,
    modifier: Modifier = Modifier,
    maxWidth: Int = 100,
    color: Color = Color(0xFF2563EB)
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(maxWidth.dp)
                .height(8.dp)
                .background(
                    color = Color(0xFFE5E7EB),
                    shape = RoundedCornerShape(4.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width((maxWidth * progress / 100).dp)
                    .background(
                        color = color,
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
        
        Text(
            text = "$progress%",
            fontSize = 14.sp,
            color = Color(0xFF6B7280)
        )
    }
}
