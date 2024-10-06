package com.example.eduskunta_feedback_app.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.eduskunta_feedback_app.data.ParliamentDatabase
import com.example.eduskunta_feedback_app.data.repository.MPRepository

class MPRefreshWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val repository: MPRepository

    init {
        val database = ParliamentDatabase.getDatabase(context)
        repository = MPRepository(database.mpDao())
    }

    override suspend fun doWork(): Result {
        return try {
            repository.refreshMPs()
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}