package com.example.board.domain.repository

import com.example.board.domain.model.Posts
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts() : Flow<List<Posts>>
    suspend fun getPostById(id: Int): Posts?
    suspend fun insertPost(posts : Posts)
    suspend fun delete(posts : Posts)
}