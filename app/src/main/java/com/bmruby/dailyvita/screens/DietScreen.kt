package com.bmruby.dailyvita.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bmruby.dailyvita.AppConstants
import com.bmruby.dailyvita.Diet
import com.bmruby.dailyvita.component.TooltipContent
import com.bmruby.dailyvita.component.primaryButton
import com.bmruby.dailyvita.component.secondaryButton
import com.bmruby.dailyvita.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DietScreen(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(color = Purple40),) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "Select the diet you follow.",
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(text = "*",
                    color = Color.Red,
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
            val size = AppConstants.diet.size
            val mod = if((size % 3) > 0)  1 else 0
            val listHeight = (((size / 3) + mod) * 130)
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(listHeight.dp),
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(space = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(space = 2.dp),
                contentPadding = PaddingValues(all = 8.dp)
            ) {
                items(AppConstants.diet.size) { index ->
                    DietItem(AppConstants.diet[index])
                }
            }
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                secondaryButton("Back", modifier = Modifier.wrapContentWidth(), onClick ={

                })
                primaryButton("Next", modifier = Modifier
                    .wrapContentWidth()
                    , onClick = {

                    })
            }


        }
    }
}

@Composable
fun DietItem(diet: Diet) {

    Row {
        Checkbox(checked = false, onCheckedChange = {
        })
        TooltipContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .padding(horizontal = 4.dp),
            name = diet.name,
            value = "",
            tooltipsText = diet.tool_tip,
        )
//        if (diet.id > 0){
//            Image(painter =
//            painterResource(id = R.drawable.info),
//                contentDescription = "info", modifier = Modifier
//                    .height(24.dp))
//        }
    }
}

@Preview
@Composable
fun DietScreenPreview(){
    DietScreen()
}