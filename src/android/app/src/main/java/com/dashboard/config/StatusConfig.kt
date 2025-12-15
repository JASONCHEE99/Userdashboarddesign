package com.dashboard.config

import androidx.compose.ui.graphics.Color
import com.dashboard.model.StatusType

data class StatusStyle(
    val label: String,
    val backgroundColor: Color,
    val textColor: Color
)

object StatusConfig {
    fun getStatusStyle(status: StatusType): StatusStyle {
        return when (status) {
            StatusType.COMPLETED -> StatusStyle(
                label = "Completed",
                backgroundColor = Color(0xFFDCFCE7),
                textColor = Color(0xFF15803D)
            )
            StatusType.IN_PROGRESS -> StatusStyle(
                label = "In Progress",
                backgroundColor = Color(0xFFDBEAFE),
                textColor = Color(0xFF1E40AF)
            )
            StatusType.PENDING -> StatusStyle(
                label = "Pending",
                backgroundColor = Color(0xFFFEF3C7),
                textColor = Color(0xFF92400E)
            )
            StatusType.CANCELLED -> StatusStyle(
                label = "Cancelled",
                backgroundColor = Color(0xFFFEE2E2),
                textColor = Color(0xFF991B1B)
            )
        }
    }
}
