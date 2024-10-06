package com.example.eduskunta_feedback_app.data.repository

import com.example.eduskunta_feedback_app.data.MPDao
import com.example.eduskunta_feedback_app.data.model.MP
import com.example.eduskunta_feedback_app.data.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MPRepository (private val mpDao: MPDao) {

    val allMPs: Flow<List<MP>> = mpDao.getAllMPs()

    fun getMPsByParty(party: String): Flow<List<MP>> {
        return mpDao.getMPsByParty(party)
    }

    fun getMPById(hetekaId: Int): Flow<MP> {
        return mpDao.getMPById(hetekaId)
    }

    suspend fun refreshMPs() {
        withContext(Dispatchers.IO) {
            val mps = RetrofitInstance.api.getMPs()
            mpDao.insertAll(mps)
        }
    }
}