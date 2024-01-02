package com.example.board

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.board.ui.theme.BoardTheme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //실제 앱 실행 시
            BoardTheme {
                MyWebview("https://www.youtube.com")
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
            Button(onClick = {}, modifier = Modifier.align(Alignment.CenterStart)) {
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
    fun MyRow() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue),
            horizontalArrangement = Arrangement.SpaceEvenly, //간격
            verticalAlignment = Alignment.CenterVertically //정렬
        ) {
            Text(text = "i1", style = TextStyle(background = Color.Gray), fontSize = 30.sp)
            Text(text = "i2", style = TextStyle(background = Color.Red), fontSize = 30.sp)
            Text(text = "i3", style = TextStyle(background = Color.Green), fontSize = 30.sp)

        }
    }

    @Composable
    fun MyCR() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = Color.Blue)
        ) {
            Text(
                text = "Hello World!",
                fontSize = 30.sp,
                color = Color.Red,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "왼쪽")

                Text(text = "중앙")
//                Spacer(modifier = Modifier.weight(1f))
                Text(text = "오른쪽")


            }
            Text(
                text = "Hello World!",
                fontSize = 30.sp,
                color = Color.Red,
            )
        }

    }

    @Composable
    fun MyCR2() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(Color.Cyan)
                .border(border = BorderStroke(5.dp, color = Color.Blue)),
            horizontalAlignment = Alignment.CenterHorizontally //가운데 정렬
        ) {
            Box(modifier = Modifier.padding(top = 20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.mc),
                    contentDescription = "mc",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(50.dp))
                )
            }
            Text(
                text = "Manchestor City",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 50.dp),
                color = Color.Black,
            )
            Text(
                text = "EPL",
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Color.Black,
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "순위",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black,
                )
                Text(
                    text = "3등",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black,
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "감독",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black,
                )
                Text(
                    text = "팹 과르디올라",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black,
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "주장",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black,
                )
                Text(
                    text = "케빈 데 브라위너",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black,
                )
            }

        }

    }

    @Composable
    fun cards(txt: String) {
        Card(
            modifier = Modifier //카드 크기
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(80.dp),//카드 모서리 둥글게
            border = BorderStroke(5.dp, Color.Blue), //카드 테두리
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)//카드 그림자
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center //카드 안에 있는 내용 가운데 정렬
            ) {
                Text(text = txt, fontSize = 30.sp)


            }
        }

    }

    @Composable
    fun MyWebview(url: String) {
        AndroidView(factory = {//안드로이드 뷰 사용
            WebView(it).apply {//웹뷰 생성
                loadUrl(url)//웹뷰에 url 로드
            }
        })
    }

    //surface란 컨탠츠를 담아놓는 컨테이너
    // text / button / box/ surface 등
    @Composable
    fun mySurface() {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color.Green,
            shape = RoundedCornerShape(20.dp), //모서리 둥글게
            shadowElevation = 20.dp //그림자
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Green
                ),//버튼 색상
            ) {
                Text(text = "버튼입니다.")
            }
        }
    }

    @Composable
    fun mySurface2() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray,
            border = BorderStroke(5.dp, Color.Red), //테두리
            contentColor = Color.Blue
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,//세로 정렬
                horizontalAlignment = Alignment.CenterHorizontally //가운데 정렬
            ) {
                Surface(
                    modifier = Modifier.size(200.dp), //사이즈
                    color = Color.Red
                ) {
                    Text("this is compose")

                }
                Spacer(modifier = Modifier.height((20.dp))) //간격
                Text("this is compose")
            }

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyScaffold() {
        Scaffold(
            topBar = { MyTopBar() },
            floatingActionButton = { MyFloationActionButton() },
            bottomBar = { MyBottomBar() }


        ) { paddingValues -> //패딩값을 주어 탑바부분에 안가려지고 밑으로 내려줌
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = "this is compose")

            }

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTopBar() {
        TopAppBar(
            title = { Text(text = "TopBar") },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {

                    Icon(Icons.Default.AccountCircle, contentDescription = "account")

                }
            },
            actions = {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "버튼")
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Color.Red)
        )
    }

    @Composable
    fun MyFloationActionButton() {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
    }

    @Composable
    fun MyBottomBar(){
        BottomAppBar(containerColor = Color.Red){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Home, contentDescription = "Menu")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Call, contentDescription = "Menu")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Settings, contentDescription = "Menu")
                }

            }
        }
    }

    @Composable
    fun mylazyColumn(){ //필요한 부분만 천천히 로드해 메모리 사용을 줄여주는 lazyrow,lazycolmnu
        val textList = listOf("1","2","3","4","5","6","7","8","9","10","1","2","3","4","5","6","7","8","9","10","1","2","3","4","5","6","7","8","9","10","1","2","3","4","5","6","7","8","9","10",)

        LazyColumn{
            items(textList){item -> Text(text = item,fontSize = 30.sp, modifier = Modifier.fillMaxWidth()) }

            }
        }
    @Composable
    fun mylazyRow(){ //필요한 부분만 천천히 로드해 메모리 사용을 줄여주는 lazyrow,lazycolmnu
        val textList = listOf("1","2","3","4","5","6","7","8","9","10","1","2","3","4","5","6","7","8","9","10","1","2","3","4","5","6","7","8","9","10","1","2","3","4","5","6","7","8","9","10",)

        LazyRow{
           items(textList){
               item -> Text(text = item, fontSize = 100.sp, modifier = Modifier.clickable{println("Clicked item : $item")})
           }

        }
    }



    @Preview(showBackground = true) //디자인 작업시 프리뷰 부분
    @Composable
    fun GreetingPreview() {
        BoardTheme {
            mylazyRow()

        }
    }
}