package com.example.boxexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            Scaffold(
                topBar = {
                  MyToolbar(data = "Login ")
                },
            ){
                Column(
                    modifier = Modifier.padding(it)
                ) {

                    LoginScreen()
                }

            }
        }
    }


    @Composable
    fun ImageLogo(){
        Image(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp),
            painter = painterResource(id = R.drawable.smile),
            contentDescription = null)

    }
    @Composable
    fun LoginScreen() {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){

            ImageLogo()
            MyEditText(lablel = "Email Address")
            Spacer(modifier = Modifier.height(16.dp))
            passwordTextField(label = "Password")

            Spacer(modifier = Modifier.height(16.dp))
            OutlindTextView()
            Spacer(modifier = Modifier.height(16.dp))
            MyButton()
        }
    }

    @Composable
    fun MyEditText(
        lablel: String
    ){

        var mail by remember {
         mutableStateOf("")
        }
        TextField(value =mail , onValueChange = {
            mail = it
        },
            trailingIcon = {
//                Icon(
//                    painter = painterResource(id = Icons.Default.Person),
//                    contentDescription = null
//                )
            },
        label = {
            textView(data = lablel)
        }
        )
    }

    @Composable
    fun passwordTextField(
        label:String
    ){
        var password  by remember {
            mutableStateOf("")
        }
        var passwordVisible by remember {
            mutableStateOf(false)
        }
        val icon = if (passwordVisible){
            painterResource(id = R.drawable.baseline_visibility_24)

        }else{

            painterResource(id = R.drawable.baseline_visibility_off_24)
        }

        TextField(
            modifier = Modifier
                .background(Color.White)
                .clip(shape = RoundedCornerShape(5.dp))
                .padding(10.dp),

            value = password,
            onValueChange = {
            password  = it
        },label ={
                 textView(data = "Password")
            },
            trailingIcon = {
                IconButton(onClick = {

                    passwordVisible = !passwordVisible
                }) {
//                    Icon(imageVector = vectorResource(id = R.drawable.bottom_bar))
                    Icon(painter = icon, contentDescription =null )
                }
            },
            visualTransformation = if(passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        )
    }

    @Composable
    fun OutlindTextView(){
        var value by remember {
            mutableStateOf("")
        }

        var passwordVisibility by remember{
            mutableStateOf(false)
        }
        var icon = if (passwordVisibility){
         painterResource(id = R.drawable.baseline_visibility_24)
        }
        else{
            painterResource(id = R.drawable.baseline_visibility_off_24)
        }

            OutlinedTextField(
                modifier = Modifier
                    .background(Color.White),
                value = value,
                onValueChange = {
                    value = it
                },
                label = {
                    textView(data = "Oulined Textfield")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(painter = icon, contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if(passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )
    }
    
    @Composable
    fun MyButton(){
        Button(onClick = { 
            val i = Intent(this, SignUp::class.java)
            startActivity(i)
        }) {
            
            Text(text = "Sign Up")
        }
    }
    
    @Composable
    fun textView(data : String){
        Text(text = data)
    }

}