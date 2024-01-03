package com.example.board.domain.usecase

import com.example.board.domain.model.InvalidPostsException
import com.example.board.domain.model.Posts
import com.example.board.domain.repository.PostRepository

class AddPosts(private val repository: PostRepository) {
    @Throws(InvalidPostsException::class)
    suspend operator fun invoke(posts : Posts){
        if(posts.title.isBlank()){
            throw InvalidPostsException("제목을 채워야 합니다.")

        }
        if(posts.content.isBlank()){
            throw InvalidPostsException("내용을 채워야 합니다.")
        }
        if(posts.author.isBlank()){
            throw InvalidPostsException("작성자를 채워야 합니다.")
        }

        repository.insertPost(posts)
    }
}