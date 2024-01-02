package com.example.board.data.local

import com.example.board.domain.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("posts/1")
    suspend fun getPost1() : Response<Post> //suspend is used for coroutines
}