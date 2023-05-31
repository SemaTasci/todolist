package com.example.todolist_.onboarding.presentation.addnote

import GetAddNoteList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingAddNoteViewModel @Inject constructor(
   private val getAddNoteList: GetAddNoteList
) : ViewModel() {
    private val addNote_ = MutableStateFlow(AddNoteListState())
    val addNote: StateFlow<AddNoteListState> = addNote_

     init {
         viewModelScope.launch {
             getAddNoteList().collectLatest{ response ->
                 addNote_.update {
                     it.copy(addedNoteList = response.data.orEmpty())
                 }
             }
         }
     }
}
