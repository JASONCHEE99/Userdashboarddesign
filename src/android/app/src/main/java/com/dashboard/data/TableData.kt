package com.dashboard.data

import com.dashboard.model.StatusType
import com.dashboard.model.TableEntry

object TableData {
    val entries = listOf(
        TableEntry("001", "Website Redesign", "Acme Corp", StatusType.IN_PROGRESS, 65, "$12,500", "2024-12-10"),
        TableEntry("002", "Mobile App Development", "TechStart Inc", StatusType.IN_PROGRESS, 40, "$28,000", "2024-12-08"),
        TableEntry("003", "Brand Identity", "Fashion Co", StatusType.COMPLETED, 100, "$8,500", "2024-12-15"),
        TableEntry("004", "E-commerce Platform", "Shop Global", StatusType.IN_PROGRESS, 75, "$45,000", "2024-12-05"),
        TableEntry("005", "Marketing Campaign", "Brand Studios", StatusType.PENDING, 0, "$15,000", "2024-12-12"),
        TableEntry("006", "Dashboard Analytics", "Data Insights", StatusType.IN_PROGRESS, 50, "$22,000", "2024-12-14"),
        TableEntry("007", "Cloud Migration", "Enterprise LLC", StatusType.COMPLETED, 100, "$38,000", "2024-12-13"),
        TableEntry("008", "Security Audit", "SecureTech", StatusType.CANCELLED, 20, "$9,500", "2024-12-11"),
    )
}
