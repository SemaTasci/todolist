package com.example.todolist_.onboarding.domain

data class NoteDataClass(
    val noteId: Int?,
    val categoryId: Int,
    val content: String,
    val title: String,
    val targetDate: Long
)