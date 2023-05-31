package com.example.todolist_.ui.todolistviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist_.onboarding.domain.repository.IOnboardingRepository
import com.example.todolist_.ui.state.ToDoListUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoListViewModel @Inject constructor(
     //factory class oluştu.(hilt)
) : ViewModel() {

    private val _toDoListUIState = MutableStateFlow(ToDoListUIState())
    val toDoListUIState: StateFlow<ToDoListUIState> = _toDoListUIState


    init {
        viewModelScope.launch {
            //repository'den todolist'i çağır ve toDoListUIState içerisine ata.
        }

    }
    /*fun saveNote(title:String,description:String)
    {
        viewModelScope.launch{
            onBoardingRepository.saveNote(title, description )  //fun fonksiyonu suspend fun fonksiyon içinde çağırdık viewmodelscoped ile.
        }

    }*/
}
    /*fun getAllNotes() {
       val title: Title = CoroutineScope(Dispatchers.Main).launch {
           _toDoListUIState.value =
       }
    }

   fun add(note: NoteCardEntity, noteDao: ToDoListDao) {
       if (note.noteId == 0) {
           noteDao.insert()
       } else {
           noteDao.update(note)
       }
   }

   suspend fun delete(note: NoteCardEntity, noteDao: ToDoListDao) {
       noteDao.delete(note)
   }

   fun add(note: NoteCardEntity) {

   }*/





