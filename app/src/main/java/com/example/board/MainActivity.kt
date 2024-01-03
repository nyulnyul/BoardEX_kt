package com.example.board


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.board.ui.activity.PostActivity
import com.example.board.ui.theme.BoardTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //실제 앱 실행 시
            BoardTheme {
                MyBoard()
            }
        }
    }


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBoard() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { Column {
            TopLogo()
            SearchBar()
        } },
        floatingActionButton = { floatingButton(navController) }
    ) { NavCon(navController)
    }
}

@Composable
fun TopLogo() {
    Box() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp), contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    "O",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                Text(
                    "B",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                Text(
                    "J",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                Text(
                    "E",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Black
                )
                Text(
                    "C",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Black
                )
                Text(
                    "T",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Black
                )
                Text(
                    text = "오브젝트 게시판",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.DarkGray
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var inputText by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
    ) {

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            placeholder = { Text(text = "검색어를 입력하세요.") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,)

            )
    }
}

@Composable
fun MyBoardList(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            LazyList()

        }
    }
}

@Composable
fun floatingButton(navController: NavController) {
    FloatingActionButton(onClick = { navController.navigate("Posting")
    }) {
        Icon(imageVector = Icons.Default.AddCircle, contentDescription = "make")
    }
}

@Composable
fun LazyList() {
    LazyColumn() {
        items(10) {
            Box(modifier = Modifier
                .padding(10.dp)
                .clickable(onClick = {})
            ) {
                Text(text = "${it}번 게시글", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) }

    )
}

@Composable
fun Posting(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    // UI 레이아웃 구성, 예를 들어 Column 사용
    Column {
        PostInputField(label = "제목", value = title, onValueChange = { title = it })
        PostInputField(label = "작성자", value = author, onValueChange = { author = it })
        PostInputField(label = "내용", value = content, onValueChange = { content = it })

        Button(onClick = { navController.navigate("MyBoardList") }) {
            Text("게시")
        }
    }
}

@Composable
fun NavCon(navController: NavController){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MyBoardList" ){
        composable("MyBoardList"){
            MyBoardList(navController)
        }
        composable("Posting"){
            Posting(navController)
        }
    }
}