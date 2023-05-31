package com.example.todolist_.di

import com.example.todolist_.core.database.ToDoListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun provideToDoListDao(database: ToDoListDatabase) = database.toDoListDao()
}