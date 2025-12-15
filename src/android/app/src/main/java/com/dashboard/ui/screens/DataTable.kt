package com.dashboard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dashboard.model.TableEntry
import com.dashboard.ui.components.ActionDropdown
import com.dashboard.ui.components.ProgressBar
import com.dashboard.ui.components.StatusBadge
import kotlin.math.ceil
import kotlin.math.min

@Composable
fun DataTable(
    data: List<TableEntry>,
    itemsPerPage: Int = 5,
    modifier: Modifier = Modifier
) {
    var currentPage by remember { mutableStateOf(1) }
    
    val totalPages = ceil(data.size.toFloat() / itemsPerPage).toInt()
    val startIndex = (currentPage - 1) * itemsPerPage
    val paginatedData = data.subList(
        startIndex,
        min(startIndex + itemsPerPage, data.size)
    )
    
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 0.dp)
                    )
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "Recent Projects",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF111827)
                    )
                    Text(
                        text = "Manage and track your ongoing projects",
                        fontSize = 14.sp,
                        color = Color(0xFF6B7280)
                    )
                }
                
                OutlinedButton(
                    onClick = { },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF374151)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Filter")
                }
            }
            
            // Table Header
            TableHeader()
            
            // Table Body
            LazyColumn(
                modifier = Modifier.weight(1f, fill = false)
            ) {
                itemsIndexed(paginatedData) { index, entry ->
                    TableRow(entry = entry)
                    if (index < paginatedData.size - 1) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                                .background(Color(0xFFE5E7EB))
                                .size(height = 1.dp, width = 0.dp)
                        )
                    }
                }
            }
            
            // Pagination
            TablePagination(
                currentPage = currentPage,
                totalPages = totalPages,
                totalItems = data.size,
                itemsPerPage = itemsPerPage,
                startIndex = startIndex,
                onPageChange = { currentPage = it }
            )
        }
    }
}

@Composable
private fun TableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF9FAFB))
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TableHeaderCell("ID", Modifier.weight(0.8f))
        TableHeaderCell("Project", Modifier.weight(2f))
        TableHeaderCell("Client", Modifier.weight(1.5f))
        TableHeaderCell("Status", Modifier.weight(1.5f))
        TableHeaderCell("Progress", Modifier.weight(2f))
        TableHeaderCell("Amount", Modifier.weight(1.2f))
        TableHeaderCell("Date", Modifier.weight(1.2f))
        TableHeaderCell("Actions", Modifier.weight(1f))
    }
}

@Composable
private fun TableHeaderCell(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Color(0xFF374151),
        modifier = modifier
    )
}

@Composable
private fun TableRow(entry: TableEntry) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // ID
        Text(
            text = "#${entry.id}",
            fontSize = 14.sp,
            color = Color(0xFF111827),
            modifier = Modifier.weight(0.8f)
        )
        
        // Project
        Text(
            text = entry.project,
            fontSize = 14.sp,
            color = Color(0xFF111827),
            modifier = Modifier.weight(2f)
        )
        
        // Client
        Text(
            text = entry.client,
            fontSize = 14.sp,
            color = Color(0xFF6B7280),
            modifier = Modifier.weight(1.5f)
        )
        
        // Status
        Box(modifier = Modifier.weight(1.5f)) {
            StatusBadge(status = entry.status)
        }
        
        // Progress
        Box(modifier = Modifier.weight(2f)) {
            ProgressBar(progress = entry.progress)
        }
        
        // Amount
        Text(
            text = entry.amount,
            fontSize = 14.sp,
            color = Color(0xFF111827),
            modifier = Modifier.weight(1.2f)
        )
        
        // Date
        Text(
            text = entry.date,
            fontSize = 14.sp,
            color = Color(0xFF6B7280),
            modifier = Modifier.weight(1.2f)
        )
        
        // Actions
        Box(modifier = Modifier.weight(1f)) {
            ActionDropdown(
                onView = { println("View: ${entry.id}") },
                onEdit = { println("Edit: ${entry.id}") },
                onDelete = { println("Delete: ${entry.id}") }
            )
        }
    }
}

@Composable
private fun TablePagination(
    currentPage: Int,
    totalPages: Int,
    totalItems: Int,
    itemsPerPage: Int,
    startIndex: Int,
    onPageChange: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFFE5E7EB),
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
            )
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Showing ${startIndex + 1} to ${min(startIndex + itemsPerPage, totalItems)} of $totalItems entries",
            fontSize = 14.sp,
            color = Color(0xFF6B7280)
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { if (currentPage > 1) onPageChange(currentPage - 1) },
                enabled = currentPage > 1,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    Icons.Default.ChevronLeft,
                    contentDescription = "Previous",
                    tint = if (currentPage > 1) Color(0xFF374151) else Color(0xFF9CA3AF)
                )
            }
            
            (1..totalPages).forEach { page ->
                if (page == currentPage) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2563EB)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.size(36.dp)
                    ) {
                        Text(
                            text = page.toString(),
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                } else {
                    OutlinedButton(
                        onClick = { onPageChange(page) },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.size(36.dp)
                    ) {
                        Text(
                            text = page.toString(),
                            color = Color(0xFF374151),
                            fontSize = 14.sp
                        )
                    }
                }
            }
            
            IconButton(
                onClick = { if (currentPage < totalPages) onPageChange(currentPage + 1) },
                enabled = currentPage < totalPages,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    Icons.Default.ChevronRight,
                    contentDescription = "Next",
                    tint = if (currentPage < totalPages) Color(0xFF374151) else Color(0xFF9CA3AF)
                )
            }
        }
    }
}
