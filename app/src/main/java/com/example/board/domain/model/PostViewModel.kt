package com.example.board.domain.model

import androidx.lifecycle.ViewModel
import com.example.board.data.local.PostDAO

class PostViewModel(private val postDao: PostDAO) : ViewModel() {

}