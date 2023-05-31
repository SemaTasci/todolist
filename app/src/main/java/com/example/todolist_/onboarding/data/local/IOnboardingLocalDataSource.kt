package com.example.todolist_.onboarding.data.local

import com.example.todolist_.local.entity.NoteCardEntity
import com.example.todolist_.local.entity.NoteDescriptionEntity

interface IOnboardingLocalDataSource {

    suspend fun getNoteList(): List<NoteCardEntity>

    suspend fun saveNoteCard(vararg noteCardEntity: NoteCardEntity)

    suspend fun getDescriptionList():List<NoteDescriptionEntity>

    suspend fun saveNoteDescription(vararg noteDescriptionEntity: NoteDescriptionEntity)

    suspend fun saveNote(noteDescriptionEntity: List<NoteDescriptionEntity>)
}