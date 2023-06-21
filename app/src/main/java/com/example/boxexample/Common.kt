package com.example.boxexample

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable


@Composable
fun MyToolbar(data: String)
{
    TopAppBar(
        title = {
            MyText(data = "$data")
        }
    )
}

@Composable
fun MyText(data : String) {
    Text(text = "$data")
}