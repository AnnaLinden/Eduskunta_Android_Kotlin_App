package com.example.eduskunta_feedback_app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.eduskunta_feedback_app.data.model.MPComment
import kotlinx.coroutines.flow.Flow

@Dao
interface MPCommentDao {
    @Query("SELECT * FROM mp_comment_table WHERE mpId = :mpId")
    fun getCommentsForMP(mpId: Int): Flow<List<MPComment>>

    @Insert
    suspend fun insertComment(comment: MPComment)
}