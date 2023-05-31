package com.example.todolist_.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class CategoryEntity(
    @PrimaryKey
    @ColumnInfo(name="categoryId")
    val categoryId:Int?=0
)
