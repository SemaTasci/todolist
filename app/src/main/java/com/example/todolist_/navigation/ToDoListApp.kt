package com.example.todolist_.navigation

import ToDoListNavigationItem
import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todolist_.local.ToDoListDao
import com.example.todolist_.ui.theme.ToDoList_Theme



@Composable
fun ToDoListApp(
) {
    ToDoList_Theme {
    Scaffold{
            val appState = rememberToDoListAppState()

            ToDoListNavigationItem(
                modifier = Modifier.padding(),
                navController = appState.navController,
                startDestinition = ToDoListNavigation.WelcomeScreen
            )
        }
    }
}


@Composable
fun rememberToDoListAppState(

    navController: NavHostController = rememberNavController()
) =
    remember(navController) {
        ToDoListAppState(navController)
    }

@Stable
class ToDoListAppState(
    val navController: NavHostController,

    ) {

    private val currentRoute: String?
        get() = navController.currentDestination?.route

    fun popBack(
        route: String?,
        inclusive: Boolean = false
    ) {
        route?.let {
            navController.popBackStack(
                route = route,
                inclusive = inclusive
            )
        } ?: run {
            navController.popBackStack()
        }

    }
}

/**
 * A composable function that returns the[Resources]. It will be recomposed when `Configuration`
 * gets updated.
 */