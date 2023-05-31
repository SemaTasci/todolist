package com.example.todolist_.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notedescription")
data class NoteDescriptionEntity(
   @PrimaryKey(autoGenerate = true) //noteDesId otomatik oluşsun
   @ColumnInfo(name = "noteDescriptionId")
   val noteDescriptionId:Int?=null,
   val noteDes:String,
   val noteTitle:String
   //note description id
    //long da olabilir
)

