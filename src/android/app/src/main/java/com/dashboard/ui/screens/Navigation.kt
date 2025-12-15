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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopNavigation(modifier: Modifier = Modifier) {
    var dropdownExpanded by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(width = 1.dp, color = Color(0xFFE5E7EB))
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo and Links
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF2563EB), Color(0xFF9333EA))
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Dashboard,
                        contentDescription = "Dashboard",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Text(
                    text = "Dashboard",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF111827)
                )
            }
            
            // Nav Links
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                NavLink("Overview")
                NavLink("Projects")
                NavLink("Analytics")
                NavLink("Reports")
            }
        }
        
        // Search, Button, and Avatar
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search Field
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Search...", fontSize = 14.sp) },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color(0xFF9CA3AF),
                        modifier = Modifier.size(16.dp)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF9FAFB),
                    unfocusedContainerColor = Color(0xFFF9FAFB),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.size(width = 256.dp, height = 40.dp),
                shape = RoundedCornerShape(8.dp),
                singleLine = true
            )
            
            // New Project Button
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2563EB)
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(0.dp)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(16.dp)
                )
                Text("New Project", modifier = Modifier.padding(start = 8.dp))
            }
            
            // Avatar Dropdown
            Box {
                Row(
                    modifier = Modifier.clickable { dropdownExpanded = !dropdownExpanded },
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color(0xFFA855F7), Color(0xFFEC4899))
                                ),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "JD",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "Menu",
                        tint = Color(0xFF6B7280),
                        modifier = Modifier.size(16.dp)
                    )
                }
                
                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false },
                    modifier = Modifier.background(Color.White, RoundedCornerShape(8.dp))
                ) {
                    // User Info
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFF3F4F6),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(bottom = 8.dp)
                    ) {
                        Text(
                            text = "John Doe",
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF111827)
                        )
                        Text(
                            text = "john.doe@example.com",
                            fontSize = 14.sp,
                            color = Color(0xFF6B7280)
                        )
                    }
                    
                    UserMenuItem(Icons.Default.Person, "Profile") { dropdownExpanded = false }
                    UserMenuItem(Icons.Default.Work, "My Projects") { dropdownExpanded = false }
                    UserMenuItem(Icons.Default.Settings, "Settings") { dropdownExpanded = false }
                    UserMenuItem(
                        Icons.Default.Logout,
                        "Sign Out",
                        textColor = Color(0xFFDC2626)
                    ) { dropdownExpanded = false }
                }
            }
        }
    }
}

@Composable
private fun NavLink(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = Color(0xFF374151),
        modifier = Modifier.clickable { }
    )
}

@Composable
private fun UserMenuItem(
    icon: ImageVector,
    text: String,
    textColor: Color = Color(0xFF374151),
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = textColor,
            modifier = Modifier.size(16.dp)
        )
        Text(text = text, color = textColor, fontSize = 14.sp)
    }
}
