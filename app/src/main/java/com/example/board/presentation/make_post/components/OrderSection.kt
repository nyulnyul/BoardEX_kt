package com.example.board.presentation.make_post.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.board.domain.util.OrderType
import com.example.board.domain.util.PostOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    postOrder : PostOrder = PostOrder.Date(OrderType.Descending),
    onOrderChange : (PostOrder) -> Unit,
) {
    Column(modifier = modifier) {
        Row(
         modifier = Modifier.fillMaxWidth()
        ){}

    }
}