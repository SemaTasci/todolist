package com.example.todolist_.onboarding.presentation.addnote

import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.local.entity.NoteDescriptionEntity
import com.example.todolist_.onboarding.domain.NoteDataClass
import com.example.todolist_.onboarding.domain.NoteDescriptionDataClass

data class AddNoteListState(
    val addedNoteList: List<NoteDataClass> = emptyList()
)
