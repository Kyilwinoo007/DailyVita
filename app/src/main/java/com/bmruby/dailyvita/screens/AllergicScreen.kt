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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bmruby.dailyvita.AppConstants
import com.bmruby.dailyvita.Item
import com.bmruby.dailyvita.component.Chip
import com.bmruby.dailyvita.component.ChipAndTextFieldLayout
import com.bmruby.dailyvita.component.primaryButton
import com.bmruby.dailyvita.component.secondaryButton
import com.bmruby.dailyvita.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllergicScreen(next:() -> Unit,back : () -> Unit){
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
                Text(text = "Write any specific alleges or sensitivity towards specific things. (optional)",
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }

            val backgroundColor = Color.Green.copy(alpha = .6f)

            val chipDataSnapshotStateList = remember {
                mutableStateListOf<Item>()
            }

            ChipAndTextFieldLayout(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                list = chipDataSnapshotStateList,
                backgroundColor = backgroundColor,
                onChipCreated = {
                    chipDataSnapshotStateList.add(it)
                },

                chip = { data: Item, index: Int->
                    Chip(data.name){
                        chipDataSnapshotStateList.removeAt(index)
                    }
                }
            )
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

@Preview
@Composable
fun AllergicScreenPreview(){
}