package com.bmruby.dailyvita.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bmruby.dailyvita.AppConstants
import com.bmruby.dailyvita.Item
import com.bmruby.dailyvita.component.primaryButton
import com.bmruby.dailyvita.component.secondaryButton
import com.bmruby.dailyvita.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthConcern(back:() -> Unit,next: () -> Unit){
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
                Text(text = "Select the top health concerns.",
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(text = "*",
                    color = Color.Red,
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(text = "(up to 5)",
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
            val size = AppConstants.healthConcerns.size
            val mod = if((size % 3) > 0)  1 else 0
            val listHeight = (((size / 3) + mod) * 130)
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(listHeight.dp),
                columns = GridCells.Adaptive(minSize = 100.dp),
                verticalArrangement = Arrangement.spacedBy(space = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(space = 2.dp),
                contentPadding = PaddingValues(all = 8.dp)
            ) {
                items(AppConstants.healthConcerns.size) { index ->
                    HealthConcernItem(AppConstants.healthConcerns[index])
                }
            }
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                secondaryButton("Back", modifier = Modifier.wrapContentWidth(), onClick ={
                    back.invoke()
                })
                primaryButton("Next", modifier = Modifier
                    .wrapContentWidth()
                    , onClick = {
                        next.invoke()
                    })
            }


        }
    }
}

@Composable
fun HealthConcernItem(data: Item) {

    val isSelected = false
    val selectedColor = if (isSelected)  Color.White else  MaterialTheme.colorScheme.primary
    val bgColor = if (isSelected)  MaterialTheme.colorScheme.primary else  Color.White
    Box(modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(20.dp))
        .background(bgColor)
        .border(width = 1.dp, color = selectedColor, shape = RoundedCornerShape(20.dp))
        .clickable { },
        contentAlignment = Alignment.Center
    ){
        Text(text = data.name,modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(10.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp, color = selectedColor)
        )

    }
}


@Preview
@Composable
fun HealthConcernPreview(){
}