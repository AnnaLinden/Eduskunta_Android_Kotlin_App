package com.example.eduskunta_feedback_app.data.network

import com.example.eduskunta_feedback_app.data.model.ExtraMPData
import com.example.eduskunta_feedback_app.data.model.MP
import retrofit2.http.GET

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Retrofit API service interface for fetching MP data and extra MP data.
interface MPApiService {
    @GET("~peterh/seating.json")
    suspend fun getMPs(): List<MP>

    @GET("~peterh/extras.json")
    suspend fun getExtraMPData(): List<ExtraMPData>
}