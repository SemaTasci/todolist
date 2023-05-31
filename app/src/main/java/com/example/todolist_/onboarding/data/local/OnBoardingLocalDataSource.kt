package com.example.todolist_.onboarding.data.local

import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.local.ToDoListDao
import com.example.todolist_.local.entity.NoteCardEntity
import com.example.todolist_.local.entity.NoteDescriptionEntity
import java.util.concurrent.Flow
import javax.inject.Inject

class OnBoardingLocalDataSource @Inject constructor(
    private val dao: ToDoListDao
) : IOnboardingLocalDataSource {

    override suspend fun getNoteList(): List<NoteCardEntity> = dao.getAllNoteCards()
    override suspend fun saveNoteCard(vararg noteCardEntity: NoteCardEntity) {
        dao.insert(*noteCardEntity)
    }

    override suspend fun getDescriptionList(): List<NoteDescriptionEntity> =
        dao.getDescriptionList()

    override suspend fun saveNoteDescription(vararg noteDescriptionEntity: NoteDescriptionEntity) {
        dao.saveNoteDescription(*noteDescriptionEntity)
    }

    override suspend fun saveNote(noteDescriptionEntity: List<NoteDescriptionEntity>) {
        TODO("Not yet implemented")
    }


}

