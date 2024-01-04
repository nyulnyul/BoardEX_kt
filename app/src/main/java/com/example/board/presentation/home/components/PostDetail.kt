package com.example.board.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.board.domain.model.Post

@Composable
fun PostDetail(post: Post) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),

        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "제목 : ${post.title}", style = MaterialTheme.typography.headlineMedium,fontWeight = FontWeight.Bold)
                Text(text = ("작성자: ${post.author}"), style = MaterialTheme.typography.bodyMedium,maxLines = 1, overflow = TextOverflow.Ellipsis)
                Divider( modifier = Modifier.padding(vertical = 4.dp))
                Text(text = post.content, maxLines = 1, style = MaterialTheme.typography.bodyMedium,overflow = TextOverflow.Ellipsis)

            }
        }
    }

}
