package com.example.board.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Posts(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val author: String,
    val title: String,
    val content: String,
    val timestamp: Long

){
    companion object{

    }
}

class InvalidPostsException(message: String): Exception(message)