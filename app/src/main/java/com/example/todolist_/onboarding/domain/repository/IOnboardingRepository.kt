package com.example.todolist_.onboarding.domain.repository

import android.provider.ContactsContract.CommonDataKinds.Note
import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.local.entity.NoteCardEntity
import com.example.todolist_.onboarding.domain.NoteDataClass
import com.example.todolist_.onboarding.domain.NoteDescriptionDataClass
import kotlinx.coroutines.flow.Flow

interface IOnboardingRepository {
    /*suspend fun getNoteCardListFromDB(): Flow<BaseResourceEvent<List<NoteDataClass>>>
    suspend fun saveNote(list: List<NoteDataClass>)
    suspend fun isNotesSaved():Flow<Boolean>

    suspend fun getNoteListFromDB(/*noteId: Long*/): Flow<BaseResourceEvent<List<NoteDataClass>>>
    suspend fun isNotesSaved():Flow<BaseResourceEvent<List<NoteDataClass>>>*/

    suspend fun getNoteListFromDB(): Flow<BaseResourceEvent<List<NoteDataClass>>>
    //suspend fun saveNote(vararg noteCardEntity: NoteCardEntity): Flow<BaseResourceEvent<List<NoteDataClass>>>
    suspend fun getNoteDescriptionListFromDB() : List<NoteDescriptionDataClass>

    suspend fun saveNoteDescription(list: List<NoteDescriptionDataClass>)
    suspend fun saveNote(title:String,description:String)
    suspend fun isAddNotesSaved():Flow<Boolean>
    }




