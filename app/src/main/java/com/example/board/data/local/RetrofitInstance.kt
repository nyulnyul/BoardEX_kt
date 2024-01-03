package com.example.board.data.local

import com.example.board.domain.model.Posts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val BASE_URL = "https://jsonplaceholder.typicode.com"
    val client = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() //GsonConverterFactory converts json to kotlin object

    fun getInstance(): Retrofit {
        return client
    }
}

