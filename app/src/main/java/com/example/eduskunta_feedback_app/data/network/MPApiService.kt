package com.example.eduskunta_feedback_app.data.network

import com.example.eduskunta_feedback_app.data.model.ExtraMPData
import com.example.eduskunta_feedback_app.data.model.MP
import retrofit2.http.GET

interface MPApiService {
    @GET("~peterh/seating.json")
    suspend fun getMPs(): List<MP>

    @GET("~peterh/extras.json")
    suspend fun getExtraMPData(): List<ExtraMPData>
}