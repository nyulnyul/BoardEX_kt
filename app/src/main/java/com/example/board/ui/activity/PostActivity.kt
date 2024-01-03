package com.example.board.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.board.MyBoard
import com.example.board.ui.theme.BoardTheme

class PostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //실제 앱 실행 시
            BoardTheme {
                Posting(){
                    finish()
                }
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
fun Posting(onPost: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    // UI 레이아웃 구성, 예를 들어 Column 사용
    Column {
        PostInputField(label = "제목", value = title, onValueChange = { title = it })
        PostInputField(label = "작성자", value = author, onValueChange = { author = it })
        PostInputField(label = "내용", value = content, onValueChange = { content = it })

        Button(onClick = onPost) {
            Text("게시")
        }
    }
}
