package com.example.todolist_.onboarding.presentation.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todolist_.ui.component.TodoListInput
import com.example.todolist_.ui.todolistviewmodel.ToDoListViewModel

@Composable
fun MyNotesScreen(state: MyNotesScreenState,
                  onChangeTitle: (String) -> Unit,
                  onChangeDescription: (String) -> Unit,
                  onSaveClick:(String,String)->Unit) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)) {
        Card( modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        elevation = CardDefaults.outlinedCardElevation(),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.secondary),
            colors = CardDefaults.outlinedCardColors()
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                TodoListInput(
                    text = state.title,
                    maxLine = 3,
                    singleLine = false,
                    onChange = {
                        onChangeTitle(it)
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .height(80.dp), label = "Başlık", placeHolder = "Not başlığı"
                )

                TodoListInput(
                    text = state.description,
                    maxLine = 3,
                    singleLine = false,
                    onChange = { text ->
                        onChangeDescription(text)
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 12.dp)
                        .height(80.dp), label = "İçerik", placeHolder = "Not içeriği"
                )
            }
        }

        Button(
            onClick = {
                onSaveClick(state.title,state.description)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        ) {
            Text(text = "KAYDET", color = Color.White)
        }
    }


}