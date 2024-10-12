package com.example.eduskunta_feedback_app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.eduskunta_feedback_app.data.model.MPComment
import kotlinx.coroutines.flow.Flow

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Data Access Object (DAO) for MP comments, providing methods to interact with the comments table.
@Dao
interface MPCommentDao {
    // Retrieves comments for a specific MP
    @Query("SELECT * FROM mp_comment_table WHERE mpId = :mpId")
    fun getCommentsForMP(mpId: Int): Flow<List<MPComment>>

    // Inserts a new comment into the database
    @Insert
    suspend fun insertComment(comment: MPComment)
}