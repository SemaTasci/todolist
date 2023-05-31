/*package com.example.todolist_.onboarding.domain.use_case

import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.local.ToDoListDao
import com.example.todolist_.onboarding.domain.NoteDataClass
import com.example.todolist_.onboarding.domain.repository.IOnboardingRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first


import javax.inject.Inject

@ViewModelScoped
class GetNoteList @Inject constructor(
    private val onboardingRepository: IOnboardingRepository
) {
     suspend operator fun invoke(): List<NoteDataClass> = onboardingRepository.getNoteListFromDB()
       /* val isNoteSaved=onboardingRepository.saveNote().first()
        return isNoteSaved
            onboardingRepository.getNoteListFromDB()
        }*/
}
*/
