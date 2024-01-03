package com.example.board.data.repository

import com.example.board.data.local.PostDAO
import com.example.board.domain.model.Posts
import com.example.board.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(private val dao : PostDAO) : PostRepository {
    override fun getPosts(): Flow<List<Posts>> {
        return  dao.getAll()
    }

    override suspend fun getPostById(id: Int): Posts? {
        return dao.getPostById(id)
    }

    override suspend fun insertPost(posts: Posts) {
        dao.insertPost(posts)
    }

    override suspend fun delete(posts: Posts) {
        dao.delete(posts)
    }

}