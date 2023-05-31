package com.example.todolist_.navigation

import androidx.annotation.StringRes

sealed class ToDoListNavigation(
    val screenRoute: String,
    val data: Any?=null,
    @StringRes val pageTitle: Int? = null

) {
    object WelcomeScreen :
        ToDoListNavigation(screenRoute = "welcome_screen")

    object AddNoteScreen:
        ToDoListNavigation(screenRoute = "add_card_screen")

    object MyNotesScreen: ToDoListNavigation(screenRoute = "my_notes_screen")

}

