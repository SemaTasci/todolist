package com.example.todolist_.onboarding.presentation.category

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyNotesScreenViewModel @Inject constructor(): ViewModel() {

    private val _myNotesState = MutableStateFlow(MyNotesScreenState())
    val myNotesState: StateFlow<MyNotesScreenState> = _myNotesState

    init {

    }

    fun onSaveClicked(title: String, description: String) {
        Log.d("DEĞERLER","title : ${title} || description : ${description}")
    }

    fun onChangeTitle(title: String) {
        _myNotesState.update {
            it.copy(
                title = title
            )
        }
    }

    fun onChangeDescription(description: String) {
        _myNotesState.update {
            it.copy(
                description=description
            )
        }
    }
}