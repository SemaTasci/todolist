package com.example.todolist_.onboarding.mapper

import com.example.todolist_.local.entity.NoteCardEntity
import com.example.todolist_.local.entity.NoteDescriptionEntity
import com.example.todolist_.onboarding.data.remote.dto.NoteDto
import com.example.todolist_.onboarding.domain.NoteDataClass
import com.example.todolist_.onboarding.domain.NoteDescriptionDataClass
import javax.inject.Inject

class NoteCardMapper @Inject constructor()
{

    fun convertNoteCardDtoToNoteDataClass(NoteDto: NoteDto): NoteDataClass {
        return NoteDataClass(
            noteId = 0,
            title = NoteDto.noteTitle,
            content = NoteDto.content,
            targetDate = NoteDto.targetDate,
            categoryId = NoteDto.categoryId
        )
    }

    fun convertNoteCardEntityToNoteDataClass(noteCardEntity: NoteCardEntity): NoteDataClass{
        return NoteDataClass(
            title = noteCardEntity.title,
            content = noteCardEntity.content,
            targetDate = noteCardEntity.targetDate,
            categoryId = noteCardEntity.categoryId,
            noteId = noteCardEntity.noteId
        )
    }

    fun convertNoteDataClassToNoteCardEntity(NoteDto: NoteDataClass): NoteCardEntity {
        return NoteCardEntity(
            noteId = NoteDto.noteId?:0,
            categoryId = NoteDto.categoryId,
            content = NoteDto.content,
            title = NoteDto.title,
            targetDate = NoteDto.targetDate
        )
    }

}