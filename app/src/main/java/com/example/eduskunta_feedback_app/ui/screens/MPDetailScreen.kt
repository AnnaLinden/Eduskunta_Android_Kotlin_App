package com.example.eduskunta_feedback_app.ui.screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.eduskunta_feedback_app.ui.getFullImageUrl
import com.example.eduskunta_feedback_app.ui.viewmodels.MPDetailViewModel
import com.example.eduskunta_feedback_app.ui.viewmodels.MPDetailViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MPDetailScreen(mpId: Int) {
    val context = LocalContext.current
    val application = context.applicationContext as Application
    val viewModel: MPDetailViewModel = viewModel(
        factory = MPDetailViewModelFactory(application, mpId)
    )
    val mp by viewModel.mp.collectAsState(initial = null)
    val comments by viewModel.comments.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MP Details") })
        }
    ) { paddingValues ->
        mp?.let { mpData ->
            val imageUrl = getFullImageUrl(mpData.pictureUrl)
            Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
                Text(text = "${mpData.firstname} ${mpData.lastname}", style = MaterialTheme.typography.titleLarge)
                Image(
                painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp)
                )
                Text(text = "Party: ${mpData.party}")
                Text(text = "Minister: ${if (mpData.minister == true) "Yes" else "No"}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Comments", style = MaterialTheme.typography.titleMedium)
                LazyColumn {
                    items(comments.size) { index ->
                        val comment = comments[index]
                        Text(text = "${comment.grade}/5: ${comment.comment}", modifier = Modifier.padding(8.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                var commentText by remember { mutableStateOf("") }
                var grade by remember { mutableStateOf(0f) }
                OutlinedTextField(
                    value = commentText,
                    onValueChange = { commentText = it },
                    label = { Text("Comment") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Grade: ${grade.toInt()}/5")
                Slider(
                    value = grade,
                    onValueChange = { grade = it },
                    valueRange = 0f..5f,
                    steps = 4,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    viewModel.addComment(commentText, grade.toInt())
                    commentText = ""
                    grade = 0f
                }) {
                    Text("Submit")
                }
            }
        }
    }
}


