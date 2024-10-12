package com.example.eduskunta_feedback_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Factory class for creating instances of MPListViewModel.
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