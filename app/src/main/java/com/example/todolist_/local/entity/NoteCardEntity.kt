package com.example.todolist_.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class NoteCardEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId")
    val noteId: Int = 0,
    val title:String,
    val targetDate:Long,
    val content:String,

    @ColumnInfo(name = "categoryId")
    val categoryId: Int,

    //val categoryId:Int?=null
)
