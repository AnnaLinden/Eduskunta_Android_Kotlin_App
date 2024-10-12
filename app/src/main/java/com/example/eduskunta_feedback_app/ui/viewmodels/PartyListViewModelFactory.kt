package com.example.eduskunta_feedback_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Factory class for creating instances of PartyListViewModel.
class PartyListViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PartyListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PartyListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}