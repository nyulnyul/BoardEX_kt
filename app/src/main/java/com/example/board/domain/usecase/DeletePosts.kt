package com.example.board.domain.usecase

import com.example.board.domain.model.Posts
import com.example.board.domain.repository.PostRepository

class DeletePosts (private val repository: PostRepository){
    suspend operator fun invoke(posts: Posts){
        repository.delete(posts)
    }
}