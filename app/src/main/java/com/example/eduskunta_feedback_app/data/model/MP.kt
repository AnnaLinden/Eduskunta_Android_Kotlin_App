package com.example.eduskunta_feedback_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mp_table")
data class MP (
    @PrimaryKey val hetekaId: Int,
    val seatNumber: Int?,
    val lastname: String?,
    val firstname: String?,
    val party: String?,
    val minister: Boolean?,
    val pictureUrl: String?
)