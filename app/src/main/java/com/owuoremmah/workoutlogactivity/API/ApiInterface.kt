package com.owuoremmah.workoutlogactivity.API

import com.owuoremmah.workoutlogactivity.models.LoginResponse
import com.owuoremmah.workoutlogactivity.models.LoginRequest
import com.owuoremmah.workoutlogactivity.models.RegisterRequest
import com.owuoremmah.workoutlogactivity.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {


        @POST("/register")
       fun registerUser(@Body registerRequest: RegisterRequest):Call<RegisterResponse>

        @POST("/login")
        suspend fun loginUser(@Body loginRequest:LoginRequest):Response<LoginResponse>
    }