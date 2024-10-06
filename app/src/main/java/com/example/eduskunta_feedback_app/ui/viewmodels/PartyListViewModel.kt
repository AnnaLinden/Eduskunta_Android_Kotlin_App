package com.example.eduskunta_feedback_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduskunta_feedback_app.data.ParliamentDatabase
import com.example.eduskunta_feedback_app.data.repository.MPRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PartyListViewModel(application: Application) : AndroidViewModel(application) {
    private val _parties = MutableStateFlow<List<String>>(emptyList())
    val parties: StateFlow<List<String>> = _parties

    private val repository: MPRepository

    init {
        val database = ParliamentDatabase.getDatabase(application)
        repository = MPRepository(database.mpDao())
        viewModelScope.launch {
            repository.allMPs.collect { mps ->
                val partySet = mps.mapNotNull { it.party }.toSet()
                _parties.value = partySet.toList().sorted()
            }
        }
    }
}