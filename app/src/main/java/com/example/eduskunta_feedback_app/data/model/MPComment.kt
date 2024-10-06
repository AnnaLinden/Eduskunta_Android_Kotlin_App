package com.example.eduskunta_feedback_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mp_comment_table")
data class MPComment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val mpId: Int,
    val comment: String,
    val grade: Int
)
