package com.example.eduskunta_feedback_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

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