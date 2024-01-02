package com.example.board.data.local

import com.example.board.domain.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {
    @GET("posts/1")
    suspend fun getPost1() : Response<Post> //suspend is used for coroutines

    @GET("posts/{number}")
    suspend fun getPostNumber(@Path("number") number : Int) : Response<Post> //suspend is used for coroutines

}