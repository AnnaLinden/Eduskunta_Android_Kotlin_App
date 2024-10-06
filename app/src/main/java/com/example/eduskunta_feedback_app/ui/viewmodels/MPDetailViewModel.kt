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

class MPDetailViewModel(application: Application, private val mpId: Int) : AndroidViewModel(application) {
    private val _mp = MutableStateFlow<MP?>(null)
    val mp: StateFlow<MP?> = _mp

    private val _comments = MutableStateFlow<List<MPComment>>(emptyList())
    val comments: StateFlow<List<MPComment>> = _comments

    private val mpDao = ParliamentDatabase.getDatabase(application).mpDao()
    private val commentDao = ParliamentDatabase.getDatabase(application).mpCommentDao()

    init {
        viewModelScope.launch {
            mpDao.getMPById(mpId).collect { mpData ->
                _mp.value = mpData
            }
        }
        viewModelScope.launch {
            commentDao.getCommentsForMP(mpId).collect { commentList ->
                _comments.value = commentList
            }
        }
    }

    fun addComment(commentText: String, grade: Int) {
        viewModelScope.launch {
            val comment = MPComment(mpId = mpId, comment = commentText, grade = grade)
            commentDao.insertComment(comment)
        }
    }
}