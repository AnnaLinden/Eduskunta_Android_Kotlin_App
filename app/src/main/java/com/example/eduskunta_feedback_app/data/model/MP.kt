package com.example.eduskunta_feedback_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Data class representing a Member of Parliament (MP) entity for the Room database.
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