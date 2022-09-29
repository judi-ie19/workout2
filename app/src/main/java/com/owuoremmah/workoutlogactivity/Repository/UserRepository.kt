package com.owuoremmah.workoutlogactivity.Repository

import com.owuoremmah.workoutlogactivity.API.APiClient
import com.owuoremmah.workoutlogactivity.API.ApiInterface
import com.owuoremmah.workoutlogactivity.models.LoginRequest
import com.owuoremmah.workoutlogactivity.models.LoginResponse
import com.owuoremmah.workoutlogactivity.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = APiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>
        = withContext(Dispatchers.IO) {
        val response = apiClient.loginUser(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest: RegisterRequest)=
        withContext(Dispatchers.IO) {
            return@withContext apiClient.registerUser(registerRequest)
        }


}

