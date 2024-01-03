package com.example.board.domain.usecase

data class PostUseCases(
    val getPosts: GetPosts,
    val deletePosts: DeletePosts,
    val addPosts: AddPosts
) {
}