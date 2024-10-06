package com.example.eduskunta_feedback_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.work.*
import com.example.eduskunta_feedback_app.ui.Navigation
import com.example.eduskunta_feedback_app.ui.theme.Eduskunta_Feedback_AppTheme
import com.example.eduskunta_feedback_app.workmanager.MPRefreshWorker
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scheduleDataRefresh()


        setContent {
            Eduskunta_Feedback_AppTheme {
                Navigation()
            }
        }
    }

    private fun scheduleDataRefresh() {
        val workRequest = PeriodicWorkRequestBuilder<MPRefreshWorker>(12, TimeUnit.HOURS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            "MPRefreshWork",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }
}