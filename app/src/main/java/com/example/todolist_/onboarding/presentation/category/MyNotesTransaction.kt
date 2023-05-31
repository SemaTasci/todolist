package com.example.todolist_.onboarding.presentation.category

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import dagger.hilt.android.qualifiers.ApplicationContext

@Composable
fun MyNotesTransaction(text: String, onSaveClicked: (String) -> Unit) {

    var text by remember { mutableStateOf(TextFieldValue()) }

    /*TodoListInput(text = descriptiontext,
        maxLine = 3,
        singleLine = false,
        onChange = {
            descriptiontext = it
        }, modifier = Modifier
            .fillMaxWidth()
            .height(80.dp), label = "Açıklama", placeHolder = "Not açıklaması")*/
    Button(
        onClick = {
            onSaveClicked(text.text)
            text = TextFieldValue()
        },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp)
        /*border = BorderStroke(1.dp,MaterialTheme.colorScheme.primary) ,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)//sınır konturu */
    ) {
        /* Text(text = descriptiontext,Modifier.fillMaxWidth()
            , textAlign = TextAlign.Center)*/
        Text(text = "KAYDET", color = Color.White)
    }
}




