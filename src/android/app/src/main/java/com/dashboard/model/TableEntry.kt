package com.dashboard.model

enum class StatusType {
    COMPLETED,
    IN_PROGRESS,
    PENDING,
    CANCELLED
}

data class TableEntry(
    val id: String,
    val project: String,
    val client: String,
    val status: StatusType,
    val progress: Int,
    val amount: String,
    val date: String
)
