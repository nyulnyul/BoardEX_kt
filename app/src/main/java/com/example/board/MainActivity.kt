package com.example.board
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.board.presentation.home.components.BoardApp

import com.example.board.ui.theme.BoardTheme
import dagger.hilt.android.HiltAndroidApp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //실제 앱 실행 시
            BoardTheme {
                BoardApp()
            }
        }
    }


}








