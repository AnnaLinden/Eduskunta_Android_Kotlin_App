package com.example.eduskunta_feedback_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MPListViewModelFactory(
    private val application: Application,
    private val party: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MPListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MPListViewModel(application, party) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}