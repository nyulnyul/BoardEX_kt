package com.example.board.presentation.home.post

import com.example.board.domain.model.Posts
import com.example.board.domain.util.OrderType
import com.example.board.domain.util.PostOrder

data class PostsState(val posts: List<Posts> = emptyList(), val postOrder: PostOrder = PostOrder.Date(
    OrderType.Descending), val isVisible : Boolean = false) {

}
