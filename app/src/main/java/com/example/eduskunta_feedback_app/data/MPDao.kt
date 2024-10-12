package com.example.eduskunta_feedback_app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduskunta_feedback_app.data.model.MP
import kotlinx.coroutines.flow.Flow

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Data Access Object (DAO) for MPs, providing methods to interact with the MPs table.
@Dao
interface MPDao {
    // Retrieves all MPs
    @Query("SELECT * FROM mp_table")
    fun getAllMPs(): Flow<List<MP>>

    // Retrieves MPs belonging to a specific party
    @Query("SELECT * FROM mp_table WHERE party = :party")
    fun getMPsByParty(party: String): Flow<List<MP>>

    // Retrieves an MP by their hetekaId
    @Query("SELECT * FROM mp_table WHERE hetekaId = :hetekaId")
    fun getMPById(hetekaId: Int): Flow<MP>

    // Inserts a list of MPs into the database, replacing existing entries on conflict
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(mps: List<MP>)
}