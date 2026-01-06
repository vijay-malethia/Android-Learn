package com.example.androiddemo.ui.screen.home

import UserResponse
import com.example.androiddemo.network.ApiClient

class HomeRepository {

    suspend fun fetchUser(): Result<List<UserResponse>> {
        return try {
            val response = ApiClient.api.getUser()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}


