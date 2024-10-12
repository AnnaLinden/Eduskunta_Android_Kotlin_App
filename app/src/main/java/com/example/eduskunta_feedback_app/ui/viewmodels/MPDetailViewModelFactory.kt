package com.example.eduskunta_feedback_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MPDetailViewModelFactory(
    private val application: Application,
    private val mpId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MPDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MPDetailViewModel(application, mpId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}