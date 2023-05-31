package com.example.todolist_.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import com.example.todolist_.navigation.ToDoListNavigation
import com.example.todolist_.onboarding.presentation.Welcome_Screen
import com.example.todolist_.onboarding.presentation.addnote.AddNoteScreen
import com.example.todolist_.onboarding.presentation.category.MyNotesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ToDoListApp(/*ToDoListNavigation.WelcomeScreen*/)
             //MyNotesScreen()
            //ToDoListApp()
            AddNoteScreen()


        }

    }
}
/*

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {


}
class MainActivity : AppCompatActivity() {

    // Room veritabanı nesnesi
    private lateinit var db: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // NavHost tanımlaması
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.NoteListScreen.route) {
                composable(route = Screen.NoteListScreen.route) {
                    NoteListScreen(navController = navController, viewModel = NoteViewModel(db.noteDao()))
                }
                composable(
                    route = Screen.NoteScreen.route + "/{noteId}",
                    arguments = listOf(navArgument("noteId") { type = NavType.LongType })
                ) { backStackEntry ->
                    val arguments = requireNotNull(backStackEntry.arguments)
                    val noteId = arguments.getLong("noteId")
                    NoteScreen(
                        navController = navController,
                        viewModel = NoteViewModel(db.noteDao()),
                        noteId = noteId
                    )
                }
            }
        }

        // Room veritabanı nesnesinin oluşturulması
        db = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java, "note_database"
        ).build()
    }

    // Option menusü tanımlaması
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Option menu elemanlarına tıklama işlevleri
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_all_notes -> {
                // Tüm notları silme işlevi
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}*/


