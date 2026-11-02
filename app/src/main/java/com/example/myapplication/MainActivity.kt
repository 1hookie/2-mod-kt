package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                // запуск с конкретным именем
                    //Hello(name = "Android", modifier = Modifier.padding(innerPadding))
                // Запуск со значением null:
                    //Hello(name = null, modifier = Modifier.padding(innerPadding))
                    //ContactColumnPreview()
                    //ContactRowPreview()
                    //ListPreview()

                // счетчик воды
                    //WaterTracker()
                // Корзина товаров
                    //ShoppingCartPreview()
                }
            }
        }
    }
}

//  Задание 1 
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        modifier = modifier
    )
}

//  Задание 2 
@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=portrait"
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=landscape"
)
@Preview(
    name = "round",
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,dpi=320,isRound=true",
    showBackground = true,
    backgroundColor = 0xFFFFFF00
)
@Composable
fun HelloPreview() {
    MyApplicationTheme {
        Hello("Android")
    }
}

//  Задание 3 
@Preview(showBackground = true)
@Composable
fun TextPreview1() {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        color = Color.Magenta,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview2() {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview3() {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        modifier = Modifier.background(Color.Green),
        style = androidx.compose.ui.text.TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
        fontSize = 24.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline
    )
}

//  Задание 4 
@Composable
fun ClickButton() {
    Button(

        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text("Нажми на меня")
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ButtonPreview() {
    MyApplicationTheme {
        ClickButton()
    }
}

//  Задание 5 
@Composable
fun Task1() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color(0xFFFF5722)),
            contentAlignment = Alignment.Center
        ) {
            Text("CГ", color = Color.Black)
        }
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun Task1Preview() {
    MyApplicationTheme {
        Task1()
    }
}