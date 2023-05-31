package com.example.todolist_.onboarding.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NoteDto(
    @SerializedName("NoteId")
    val noteId: Int,
    val content:String,
    val targetDate:Long,
    val categoryId:Int,


    @SerializedName("NoteTitle")
    val noteTitle: String,


)
