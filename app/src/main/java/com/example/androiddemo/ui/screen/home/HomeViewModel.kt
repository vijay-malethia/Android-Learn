package com.example.androiddemo.ui.screen.home

import UserResponse
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = HomeRepository()

    var isLoading by mutableStateOf(false)
        private set

    var users by mutableStateOf<List<UserResponse>>(emptyList())
        private set

    init {
        fetchSomeData()
    }

    private fun fetchSomeData() {
        viewModelScope.launch {
            isLoading = true
            try {
                val result = repository.fetchUser()
                if (result.isSuccess) {
                    users = result.getOrNull().orEmpty()
                } else {
                    Log.e("HomeViewModel", "API failed", result.exceptionOrNull())
                }
            } catch (e: Exception) {
                Log.e("HomeViewModel", "API failed", e)
            } finally {
                isLoading = false
            }
        }
    }
}
