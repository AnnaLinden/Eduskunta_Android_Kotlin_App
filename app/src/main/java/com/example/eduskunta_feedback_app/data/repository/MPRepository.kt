package com.example.eduskunta_feedback_app.data.repository

import com.example.eduskunta_feedback_app.data.MPDao
import com.example.eduskunta_feedback_app.data.model.MP
import com.example.eduskunta_feedback_app.data.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Repository class handling data operations for MPs, including fetching from network and database.
class MPRepository (private val mpDao: MPDao) {

    // Flow emitting all MPs from the database
    val allMPs: Flow<List<MP>> = mpDao.getAllMPs()

    // Retrieves MPs by party
    fun getMPsByParty(party: String): Flow<List<MP>> {
        return mpDao.getMPsByParty(party)
    }

    // Retrieves a single MP by ID
    fun getMPById(hetekaId: Int): Flow<MP> {
        return mpDao.getMPById(hetekaId)
    }

    // Refreshes the MP data by fetching from the network and storing in the database
    suspend fun refreshMPs() {
        withContext(Dispatchers.IO) {
            val mps = RetrofitInstance.api.getMPs()
            mpDao.insertAll(mps)
        }
    }
}