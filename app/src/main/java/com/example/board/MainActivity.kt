package com.example.board

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.board.ui.theme.BoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //실제 앱 실행 시
            BoardTheme {
                BoxEx()
            }
        }
    }

    @Composable
    fun myText() {

        Text(
            text = "Hello World!",
            fontSize = 30.sp,
            color = Color.Red,
//        fontStyle = FontStyle.itali,
//        fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp), //패딩
            style = TextStyle(background = Color.Blue)
        )
    }

    @Composable
    fun myBtn() {
        val context = LocalContext.current

        Button(
            onClick = {
                Log.d("TAG", "myBtn: ")
                Toast.makeText(context, "버튼 클릭", Toast.LENGTH_SHORT).show()
            },
            colors = buttonColors( //버튼 색상
                contentColor = Color.White, //글자색
                containerColor = Color.Red //버튼 색
            ),
            modifier = Modifier //버튼 크기
                .width(200.dp) //너비
                .height(200.dp) //높이
        ) {
            Text(
                text = "버튼입니다. 아시겠습니까? 아세요 좀", lineHeight = 100.sp //줄간격
                , fontSize = 10.sp //글자크기
                , fontWeight = FontWeight.Bold //글자 굵기
                , color = Color.White //글자 색
                , modifier = Modifier.padding(10.dp) //패딩
                , style = TextStyle(background = Color.Blue) //글자 배경색

            )


        }
    }

    @Composable
    fun column1() {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Hello World!",
                fontSize = 30.sp,
                color = Color.Red,
//        fontStyle = FontStyle.itali,
//        fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp), //패딩
                style = TextStyle(background = Color.Blue)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Divider(color = Color.Black)
            Text(
                text = "안녕 World!",
                fontSize = 30.sp,
                color = Color.Red,
//        fontStyle = FontStyle.itali,
//        fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp), //패딩
                style = TextStyle(background = Color.Blue)
            )
            Text(
                text = "Hello 세상!",
                fontSize = 30.sp,
                color = Color.Red,
//        fontStyle = FontStyle.itali,
//        fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp), //패딩
                style = TextStyle(background = Color.Blue)
            )
        }

    }

    @Composable
    fun sympleCntBnt() {
        var cnt by remember { mutableStateOf(0) } //상태값 저장
        Button(onClick = { cnt++ }, modifier = Modifier.fillMaxSize()) {
            Text(text = "버튼 클릭 횟수 : $cnt", fontSize = 20.sp)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField1() {
        var textState by remember { mutableStateOf("안녕하세요") }
        TextField(value = textState, onValueChange = { textState = it }, label = { Text("입력칸") })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField2() {
        var textState by remember { mutableStateOf("안녕하세요") }
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("입력칸") })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField3() {
        var textState by remember { mutableStateOf("") } //입력값
        var enteredText by remember { mutableStateOf("") } //결과값

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = textState,
                onValueChange = { textState = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("입력칸") }
            )
            Button(onClick = { enteredText = textState }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "입력")
            }
            Text(text = "입력값 : $enteredText", modifier = Modifier.fillMaxWidth())
        }

    }

    @Composable
    fun MyImage() {
        Image(
            painter = painterResource(id = R.drawable.kotlin),
            contentDescription = "코틀린",
        )
    }

    //
    @Composable
    fun MyImage2() {

        AsyncImage(
            model = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fmedia.bunjang.co.kr%2Fproduct%2F236724557_%257Bcnt%257D_1695101881_w%257Bres%257D.jpg&tbnid=xp3UItw0oo5tBM&vet=12ahUKEwjv0NaOxb2DAxVjc_UHHZ3SBTMQMygMegQIARBp..i&imgrefurl=https%3A%2F%2Fm.bunjang.co.kr%2Fproducts%2F236724557&docid=6IH4TLFbgy4juM&w=900&h=1200&itg=1&q=%EC%A0%95%EC%B2%98%EC%82%B0%EA%B8%B0&ved=2ahUKEwjv0NaOxb2DAxVjc_UHHZ3SBTMQMygMegQIARBp",
            contentDescription = "정처산기"
        )
    }

    @Composable
    fun BoxEx() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue),
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(color = Color.Red)
                    .padding(10.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(text = "Box1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(color = Color.Gray)
                    .padding(10.dp)
                    .align(Alignment.TopCenter)
            ) {
                Text(text = "Box1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(color = Color.Yellow)
                    .padding(10.dp)
                    .align(Alignment.TopEnd)
            ) {
                Text(text = "Box1", color = Color.Black)
            }
            Button(onClick = {}, modifier = Modifier.align(Alignment.CenterStart)){
                Text(text = "중앙 좌측")

            }
            Button(onClick = {}, modifier = Modifier.align(Alignment.Center)) {
                Text(text = "중앙 중앙")

            }
            Button(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)) {
                Text(text = "중앙 우측")

            }
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(color = Color.Red)
                    .padding(10.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(text = "Box1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(color = Color.Gray)
                    .padding(10.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(text = "Box1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(color = Color.Yellow)
                    .padding(10.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text(text = "Box1", color = Color.Black)
            }
        }
    }

    @Composable
    fun MyRow(){
        Row (modifier = Modifier.fillMaxSize().background(color = Color.Blue),
            horizontalArrangement = Arrangement.SpaceEvenly, //간격
            verticalAlignment = Alignment.CenterVertically //정렬
        ){
            Text(text ="i1", style = TextStyle(background = Color.Gray), fontSize = 30.sp)
            Text(text ="i2", style = TextStyle(background = Color.Red), fontSize = 30.sp)
            Text(text ="i3", style = TextStyle(background = Color.Green), fontSize = 30.sp)

        }
    }

    
    @Preview(showBackground = true) //디자인 작업시 프리뷰 부분
    @Composable
    fun GreetingPreview() {
        BoardTheme {

            MyRow()
        }
    }
}