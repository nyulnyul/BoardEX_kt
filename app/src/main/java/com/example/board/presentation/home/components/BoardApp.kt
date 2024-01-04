package com.example.board.presentation.home.components

import PostList
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.board.domain.model.Post
import com.example.board.presentation.home.post.SearchBar
import com.example.board.presentation.home.post.TopLogo
import com.example.board.presentation.util.PostDetailScreen
import com.example.board.presentation.util.PostListScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoardApp() {
    val navController = rememberNavController()
    val posts = remember { mutableStateListOf<Post>() }
    var currentRoute by remember { mutableStateOf(navController.currentDestination?.route) }

    // NavController의 현재 경로가 변경될 때마다 currentRoute 상태를 업데이트
    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentRoute = destination.route
        }
    }




    Scaffold(
        topBar = {
            Column {
                TopLogo()
                SearchBar()
                Spacer(modifier = Modifier.padding(6.dp))

            }
        },
        floatingActionButton = {


            if (currentRoute != "postCreate") {
                FloatingActionButton(onClick = {

                    navController.navigate("postCreate")
                    Log.d("Navigation", "Current route: ${navController.currentDestination?.route}")
                }) {
                    Icon(Icons.Filled.Add, contentDescription = "게시글쓰기")
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "postList",
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable("postList") {
                PostListScreen(posts = posts, navController = navController)
            }
            composable(
                "postDetail/{postId}",
                arguments = listOf(navArgument("postId") { type = NavType.IntType })
            ) { backStackEntry ->

                val postId = backStackEntry.arguments?.getInt("postId")
                PostDetailScreen(postId = postId, posts = posts, navController = navController)
            }
            composable("postCreate") {

                PostCreate(onCreatePost = { post ->

                    posts.add(post)
                    navController.popBackStack()
                })
            }
        }
    }
}
