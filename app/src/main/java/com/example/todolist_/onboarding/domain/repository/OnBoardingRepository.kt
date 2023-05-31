package com.example.todolist_.onboarding.domain.repository


import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.core.repository.BaseRepository
import com.example.todolist_.di.IoDispatcher
import com.example.todolist_.onboarding.data.local.IOnboardingLocalDataSource
import com.example.todolist_.onboarding.domain.NoteDataClass
import com.example.todolist_.onboarding.domain.NoteDescriptionDataClass
import com.example.todolist_.onboarding.mapper.NoteCardMapper
import com.example.todolist_.onboarding.mapper.NoteDescriptionDataMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class OnBoardingRepository @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val onBoardingLocalDataSource: IOnboardingLocalDataSource,
    private val noteDataMapper: NoteCardMapper,
    private val noteDescriptionDataMapper: NoteDescriptionDataMapper
) : BaseRepository(ioDispatcher), IOnboardingRepository {

    override suspend fun getNoteListFromDB(): Flow<BaseResourceEvent<List<NoteDataClass>>> {
        return callDb(call = {
            onBoardingLocalDataSource.getNoteList()
        }, mapperCall = {
            it.map { noteCardEntity->
                noteDataMapper.convertNoteCardEntityToNoteDataClass(noteCardEntity)
            }
        })
    }


    override suspend fun getNoteDescriptionListFromDB(): List<NoteDescriptionDataClass> {
        val noteDataDescriptionList = mutableListOf<NoteDescriptionDataClass>()
        val noteDataDescriptionDB = onBoardingLocalDataSource.getDescriptionList()
        noteDataDescriptionDB.forEach { noteDescriptionEntity ->
            noteDataDescriptionList.add(
                noteDescriptionDataMapper.convertNoteDesEntityToNoteDesDataClass(
                    noteDescriptionEntity
                )
            )
        }
        return noteDataDescriptionList
    }

    override suspend fun saveNoteDescription(list: List<NoteDescriptionDataClass>) {
        onBoardingLocalDataSource.saveNoteDescription(*(list.map {
            noteDescriptionDataMapper.convertNoteDesDataToNoteDesEntity(it)
        }.toTypedArray()))
    }

    override suspend fun saveNote(title: String, description: String) {
        val noteObject = NoteDescriptionDataClass(
            title = title,
            description = description
        )
        onBoardingLocalDataSource.saveNote((listOf(noteObject).map {
            noteDescriptionDataMapper.convertNoteDesDataToNoteDesEntity(it)
        }))
    }

    override suspend fun isAddNotesSaved(): kotlinx.coroutines.flow.Flow<Boolean> {
        TODO("Not yet implemented")
    }

    /*override suspend fun saveNote(vararg noteCardEntity: NoteCardEntity): Flow<BaseResourceEvent<List<NoteDataClass>>> {

        dao.saveNote(*noteCardEntity)
        return flow {  }

    }*/
}

