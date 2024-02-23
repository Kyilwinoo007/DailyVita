package com.bmruby.dailyvita.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.bmruby.dailyvita.Item

@Composable
fun primaryButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    ElevatedButton(
        modifier = modifier,
        onClick = { onClick() },
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        )
    ) {
        Text(text = text)

    }
}
@Composable
fun secondaryButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    OutlinedButton(
        modifier = modifier,
        onClick = { onClick() },
//        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSecondaryContainer),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onSecondaryContainer)
    ) {
        Text(text = text)
    }
}


@Composable
fun Chip(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.LightGray else MaterialTheme.colorScheme.primary
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
@Composable
private fun MyChip(
    backgroundColor: Color,
    data: Item,
    onDeleteClick: () -> Unit
) {
    Chip(
       name = data.name,
       onSelectionChanged = {
           data ->
       }
    )
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class)
@Composable
fun ChipAndTextFieldLayout(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    list: List<Item> = emptyList(),
    onChipCreated: (Item) -> Unit,
    chip: @Composable (data: Item, index: Int) -> Unit
) {

    var text by remember {
        mutableStateOf("")
    }

    val focusRequester = remember {
        FocusRequester()
    }

    val keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current

//    val photoPicker =
//        rememberLauncherForActivityResult(PhotoPicker()) { uris ->
//            uris.firstOrNull()?.let { uri: Uri ->
//                onChipCreated(
//                    ChipData(
//                        uri = uri,
//                        text = text
//                    )
//                )
//                text = ""
//                // Open keyboard after new chip is added
//                keyboardController?.show()
//            }
//        }

    LaunchedEffect(Unit) {
        delay(100)
        focusRequester.requestFocus()
    }

    FlowRow(
        modifier = modifier
            .drawWithContent {
                drawContent()
                drawLine(
                    Color.Green.copy(alpha = .6f),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 4.dp.toPx()
                )
            },
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        list.forEachIndexed { index, item ->
            key(item.id) {
                chip(item, index)
            }
        }

        Box(
            modifier = Modifier
                .height(54.dp)
                // This minimum width that TextField can have
                // if remaining space in same row is smaller it's moved to next line
                .widthIn(min = 80.dp)
                // TextField can grow as big as Composable width
                .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                modifier = Modifier.focusRequester(focusRequester),
                value = text,
                textStyle = TextStyle(
                    fontSize = 20.sp
                ),
                cursorBrush = SolidColor(backgroundColor),
                singleLine = true,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (text.isNotEmpty()) {
                            keyboardController?.hide()
                        }
                    }
                )
            )
        }
    }
}