package com.example.board.presentation.home.components

import com.example.board.domain.model.Posts
import com.example.board.domain.util.PostOrder

sealed class PostsEvent{
    data class Order(val postOrder: PostOrder):PostsEvent()
    data class  DeletePost(val posts : Posts):PostsEvent()
    object RestorePost:PostsEvent()
    object ToggleOrderSection:PostsEvent()

}
