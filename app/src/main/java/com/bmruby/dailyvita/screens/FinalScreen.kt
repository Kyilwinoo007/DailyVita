package com.bmruby.dailyvita.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bmruby.dailyvita.AppConstants
import com.bmruby.dailyvita.component.primaryButton
import com.bmruby.dailyvita.component.secondaryButton
import com.bmruby.dailyvita.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinalScreen(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(color = Purple40),) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row {
                Text(text = "Is your daily exposure to sun is limited.",
                    fontFamily = FontFamily.Default,
                    fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "*",
                    color = Color.Red,
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }

            val radioOptions = listOf("Yes","No",)
            var selectedOption by remember { mutableStateOf(radioOptions[0]) }
            radioOptions.forEach { value ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (value == selectedOption),
                        onClick = { selectedOption = value }
                    )
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            Row {
                Text(text = "Do you current smoke(tobacco or marijuana)",
                    fontFamily = FontFamily.Default,
                    fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "*",
                    color = Color.Red,
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }

            val smokeRadioOption = listOf("Yes","No",)
            var smokeSelectedOption by remember { mutableStateOf(smokeRadioOption[1]) }
            smokeRadioOption.forEach { value ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (value == smokeSelectedOption),
                        onClick = { smokeSelectedOption = value }
                    )
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            Row {
                Text(text = "On average, how many alcoholic beverages do you have in a week?",
                    fontFamily = FontFamily.Default,
                    fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "*",
                    color = Color.Red,
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }

            val alcoholicRadioOption = listOf("0-1","2-5","5+")
            var alcoholicSelectedOption by remember { mutableStateOf(alcoholicRadioOption[0]) }
            alcoholicRadioOption.forEach { value ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (value == alcoholicSelectedOption),
                        onClick = { alcoholicSelectedOption = value }
                    )
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            primaryButton("Get my personalized vitamin", modifier = Modifier
                .fillMaxWidth()
                , onClick = {
                })

        }
    }
}