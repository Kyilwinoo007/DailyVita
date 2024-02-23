package com.bmruby.dailyvita.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bmruby.dailyvita.R
import com.bmruby.dailyvita.component.primaryButton
import com.bmruby.dailyvita.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(getStarted:() -> Unit){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(color = Purple40),) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Welcome to DailyVita", fontFamily = FontFamily.Default, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Hello,we are here to make your life healthier and happier", fontFamily = FontFamily.Default, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(14.dp))
            Image(painter =
                painterResource(id = R.drawable.welcome),
                contentDescription = "Welcome", modifier = Modifier
                    .height(250.dp))
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "We will ask couple of questions to better understand your vitamin need", fontFamily = FontFamily.Default, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            primaryButton("Get Started", modifier = Modifier
                .fillMaxWidth()
                , onClick = {
                    getStarted.invoke()
            })

        }
    }
}

@Preview
@Composable
fun  WelcomeScreenPreview(){
}

