package com.example.todolist_.core.database

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist_.local.IOnboardingDao
import com.example.todolist_.local.ToDoListDao
import com.example.todolist_.local.entity.CategoryEntity
import com.example.todolist_.local.entity.NoteCardEntity
import com.example.todolist_.local.entity.NoteDescriptionEntity
import com.example.todolist_.navigation.ToDoListNavigation

@Database(
    version = 2,
    entities = [CategoryEntity::class, NoteCardEntity::class,NoteDescriptionEntity::class]
)
abstract class ToDoListDatabase : RoomDatabase() {

    abstract fun toDoListDao(): ToDoListDao


}

