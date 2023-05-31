import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todolist_.core.database.ToDoListDatabase
import com.example.todolist_.local.ToDoListDao
import com.example.todolist_.navigation.ToDoListApp
import com.example.todolist_.navigation.ToDoListNavigation
import com.example.todolist_.onboarding.domain.repository.OnBoardingRepository
import com.example.todolist_.onboarding.presentation.ToDoListHomeScreen

import com.example.todolist_.onboarding.presentation.Welcome_Screen
import com.example.todolist_.onboarding.presentation.addnote.AddNoteScreen
import com.example.todolist_.onboarding.presentation.category.MyNotesScreen
import com.example.todolist_.onboarding.presentation.category.MyNotesScreenViewModel
import com.example.todolist_.ui.state.ToDoListUIState
import com.example.todolist_.ui.todolistviewmodel.ToDoListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun ToDoListNavigationItem(
    modifier: Modifier,
    navController: NavHostController,
    startDestinition: ToDoListNavigation
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestinition.screenRoute
    ) {
        composable(route = ToDoListNavigation.WelcomeScreen.screenRoute) {
            Welcome_Screen(navController = navController)
        }

        composable(
            route = ToDoListNavigation.AddNoteScreen.screenRoute
        ) {
            val viewModel = hiltViewModel<ToDoListViewModel>()
            val state = viewModel.toDoListUIState.collectAsState()
            AddNoteScreen()/*state = state.value*/
        }

        composable(
            route = ToDoListNavigation.MyNotesScreen.screenRoute
        ) {
            val viewModel = hiltViewModel<MyNotesScreenViewModel>()
            val state = viewModel.myNotesState.collectAsState()
            MyNotesScreen(
                state = state.value,
                onChangeTitle = viewModel::onChangeTitle,
                onChangeDescription = viewModel::onChangeDescription,
                onSaveClick = viewModel::onSaveClicked
            )
        }

        //NoteEkranı************
        /*composable(route=ToDoListNavigation.To_Do_List_Home_Screen.screenRoute+"/{noteId}",
        arguments = listOf(navArgument("noteId"){type= NavType.LongType})
        ){
            backStackEntry -> val arguments= requireNotNull(backStackEntry.arguments)
            val noteId=arguments.getLong("noteId")
            val noteDao = ToDoListDatabase
            To_Do_List_Home_Screen(
                navController =navController,
              viewModel = ToDoListViewModel(),
                noteId = 0L, noteDao =noteDao
            )
        }*/


    }
}
