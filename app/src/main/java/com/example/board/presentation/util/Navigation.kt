package com.example.board.presentation.util

import PostList
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.board.domain.model.Post
import com.example.board.presentation.home.components.PostDetail


@Composable
fun PostListScreen(posts: List<Post>, navController: NavController) {
    PostList(posts = posts) { post ->
        navController.navigate("postDetail/${post.id}")
    }
}

@Composable
fun PostDetailScreen(postId: Int?, posts: List<Post>, navController: NavController) {
    postId?.let { id ->

        val post = posts.find { it.id == id }
        post?.let {

            PostDetail(post = it)
        } ?: run {

            Text("게시물을 찾을 수 없습니다.")
        }
    } ?: run {

        Text("잘못된 접근입니다.")
    }
}
