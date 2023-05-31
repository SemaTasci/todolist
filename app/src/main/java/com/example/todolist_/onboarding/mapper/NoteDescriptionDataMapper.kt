package com.example.todolist_.onboarding.mapper

import com.example.todolist_.local.entity.NoteDescriptionEntity
import com.example.todolist_.onboarding.domain.NoteDescriptionDataClass
import javax.inject.Inject

class NoteDescriptionDataMapper @Inject constructor(){


    fun convertNoteDesEntityToNoteDesDataClass(noteDescriptionEntity: NoteDescriptionEntity): NoteDescriptionDataClass {
        return NoteDescriptionDataClass(
            description = noteDescriptionEntity.noteDes,
            title = noteDescriptionEntity.noteTitle
        )
    }

    fun convertNoteDesDataToNoteDesEntity(note: NoteDescriptionDataClass): NoteDescriptionEntity {
        return NoteDescriptionEntity(
            noteDes = note.description,
            noteTitle = note.title,
        )
    }
}