package com.example.board.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Posts(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val author: String,
    val title: String,
    val content: String,

)
