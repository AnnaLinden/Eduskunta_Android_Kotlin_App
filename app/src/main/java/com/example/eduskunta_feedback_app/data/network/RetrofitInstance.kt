package com.example.eduskunta_feedback_app.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Singleton object providing a Retrofit instance for API calls.
object RetrofitInstance {
    private const val BASE_URL = "https://users.metropolia.fi/"

    // Lazy initialization of the Retrofit API service
    val api: MPApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MPApiService::class.java)
    }
}