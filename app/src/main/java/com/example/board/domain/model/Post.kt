package com.example.board.domain.model

data class Post( //data class is used to store data
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,

)
