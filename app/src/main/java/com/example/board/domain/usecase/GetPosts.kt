package com.example.board.domain.usecase

import com.example.board.domain.model.Posts
import com.example.board.domain.repository.PostRepository
import com.example.board.domain.util.OrderType
import com.example.board.domain.util.PostOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetPosts(private val repository : PostRepository) {
    operator fun invoke(postorder : PostOrder = PostOrder.Date(OrderType.Descending)) : Flow<List<Posts>> {

        return repository.getPosts().map{
            when(postorder.orderType){
                is OrderType.Ascending ->{
                    when(postorder){
                        is PostOrder.Title -> it.sortedBy { it.title.lowercase() }
                        is PostOrder.Date -> it.sortedBy { it.timestamp }
                        is PostOrder.content -> it.sortedBy { it.content}
                        is PostOrder.arthur -> it.sortedBy { it.author }
                    }
                }
                is OrderType.Descending ->{
                    when(postorder){
                        is PostOrder.Title -> it.sortedBy { it.title.lowercase() }
                        is PostOrder.Date -> it.sortedBy { it.timestamp }
                        is PostOrder.content -> it.sortedBy { it.content}
                        is PostOrder.arthur -> it.sortedBy { it.author }
                    }
                }

                else -> it
            }
        }
    }

}