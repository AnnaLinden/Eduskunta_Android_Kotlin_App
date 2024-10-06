package com.example.eduskunta_feedback_app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduskunta_feedback_app.data.model.MP
import kotlinx.coroutines.flow.Flow

@Dao
interface MPDao {
    @Query("SELECT * FROM mp_table")
    fun getAllMPs(): Flow<List<MP>>

    @Query("SELECT * FROM mp_table WHERE party = :party")
    fun getMPsByParty(party: String): Flow<List<MP>>

    @Query("SELECT * FROM mp_table WHERE hetekaId = :hetekaId")
    fun getMPById(hetekaId: Int): Flow<MP>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(mps: List<MP>)
}