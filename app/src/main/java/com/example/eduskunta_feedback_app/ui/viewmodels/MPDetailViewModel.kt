package com.example.eduskunta_feedback_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduskunta_feedback_app.data.ParliamentDatabase
import com.example.eduskunta_feedback_app.data.model.MP
import com.example.eduskunta_feedback_app.data.model.MPComment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: ViewModel for the MPDetailScreen, handling MP details and comments.
class MPDetailViewModel(application: Application, private val mpId: Int) : AndroidViewModel(application) {
    // Holds the MP data
    private val _mp = MutableStateFlow<MP?>(null)
    val mp: StateFlow<MP?> = _mp

    // Holds the list of comments for the MP
    private val _comments = MutableStateFlow<List<MPComment>>(emptyList())
    val comments: StateFlow<List<MPComment>> = _comments

    private val mpDao = ParliamentDatabase.getDatabase(application).mpDao()
    private val commentDao = ParliamentDatabase.getDatabase(application).mpCommentDao()

    init {
        // Fetch MP data
        viewModelScope.launch {
            mpDao.getMPById(mpId).collect { mpData ->
                _mp.value = mpData
            }
        }
        // Fetch comments for the MP
        viewModelScope.launch {
            commentDao.getCommentsForMP(mpId).collect { commentList ->
                _comments.value = commentList
            }
        }
    }

    // Adds a new comment to the database
    fun addComment(commentText: String, grade: Int) {
        viewModelScope.launch {
            val comment = MPComment(mpId = mpId, comment = commentText, grade = grade)
            commentDao.insertComment(comment)
        }
    }
}