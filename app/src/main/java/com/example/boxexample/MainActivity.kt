package com.example.boxexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boxexample.ui.theme.BoxExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BoxExample1()
                }
            }
        }
    }
}

@Composable
fun BoxExample1() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {

        Box(
            modifier = Modifier
                .background(color = Color.Green)
                .size(180.dp, 300.dp)
        ) {

            Box(
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .size(125.dp, 100.dp)
                    .clip(shape = RoundedCornerShape(
                        topEnd = 10.dp,
                        topStart = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                    )
            ) {
            }

            Text(
                text = "Hi",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .background(color = Color.White)
                    .size(90.dp, 50.dp)
            )
        }
    }
}

@Composable
fun MyUI() {
    Box(
        modifier = Modifier
            .size(size = 100.dp)
            .graphicsLayer {
                clip = true // don't forget this
                shape = CircleShape
                 shadowElevation = 20f // you can also set elevation
            }
            .background(color = Color.Green)
    ) {
    }
}

@Composable
fun Greeting(name: String) {
//    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxExampleTheme {
//        Greeting("Android")
//        BoxExample1()
        MyUI()
    }
}