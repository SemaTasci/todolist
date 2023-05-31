package com.example.todolist_.ui.state

import com.example.todolist_.onboarding.domain.NoteDataClass

data class ToDoListUIState(
    val notes: List<NoteDataClass> = emptyList()
)
