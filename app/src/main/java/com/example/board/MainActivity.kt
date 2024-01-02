package com.example.board


import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.AddCircle

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBoard(){
    Scaffold(
        topBar = {TopAppBar(
            title = {Text(text = "오브젝트 게시판", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))},
        )},
        floatingActionButton = {floatingButton()}
    ){paddingValues -> MyBoardList(paddingValues) }
}

@Composable
fun MyBoardList(paddingValues : PaddingValues){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp), elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), shape = RoundedCornerShape(10.dp)
    ){
        Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {

        }
    }
}

@Composable
fun floatingButton(){
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.AddCircle, contentDescription = "make")
    }
}

