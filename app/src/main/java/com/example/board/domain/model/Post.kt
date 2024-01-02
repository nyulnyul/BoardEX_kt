package com.example.board.domain.model

data class Post(
    val id: Int,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String
)
