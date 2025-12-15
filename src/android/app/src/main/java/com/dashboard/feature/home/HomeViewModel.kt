package com.dashboard.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    init {
        loadData()
    }
    
    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            // 模拟数据加载
            val stats = listOf(
                StatItem("Total Revenue", "$86.4K", "+12.5%", true),
                StatItem("Active Users", "2,520", "+8.2%", true),
                StatItem("Conversion Rate", "3.42%", "+2.1%", true),
                StatItem("Achievements", "127", "+15", true)
            )
            
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                stats = stats
            )
        }
    }
    
    fun refresh() {
        loadData()
    }
}
