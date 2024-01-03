package com.example.board.presentation.home.post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.board.domain.model.Posts
import com.example.board.domain.usecase.PostUseCases
import com.example.board.domain.util.OrderType
import com.example.board.domain.util.PostOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val postUseCases: PostUseCases) : ViewModel() {

    private val _state = mutableStateOf<PostsState>(PostsState())
    val state: State<PostsState> = _state

    private var recentlyDeletedPost : Posts? = null

    init {
        getPosts(PostOrder.Date(OrderType.Descending))
    }



    fun onEvent(event: PostsEvent) {
        when (event) {
            is PostsEvent.Order -> {
                if(state.value.postOrder::class == event.postOrder::class && state.value.postOrder.orderType == event.postOrder.orderType){
                    return
                }


            }

            is PostsEvent.DeletePost -> {
                viewModelScope.launch {
                    postUseCases.deletePosts(event.posts)
                    recentlyDeletedPost= event.posts}

            }

            is PostsEvent.RestorePost -> {

                viewModelScope.launch {
                    postUseCases.addPosts(recentlyDeletedPost ?: return@launch)
                    recentlyDeletedPost = null


                }


            }

            is PostsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(isVisible = !state.value.isVisible)

            }
        }


    }
    private fun getPosts(postOrder: PostOrder){
        postUseCases.getPosts(postOrder).onEach {
            _state.value = state.value.copy(posts = it, postOrder = postOrder)
        }.launchIn(viewModelScope)
    }
}