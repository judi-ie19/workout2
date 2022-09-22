package com.owuoremmah.workoutlogactivity.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APiClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://192.81.215.35")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }
}