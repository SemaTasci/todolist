package com.example.todolist_.onboarding.presentation.notecard

import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.onboarding.domain.NoteDataClass

data class ToDoListSelectionState(
    val noteList: BaseResourceEvent<List<NoteDataClass>> = BaseResourceEvent.Loading()
)
