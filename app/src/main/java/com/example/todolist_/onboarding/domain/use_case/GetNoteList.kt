package com.example.todolist_.onboarding.domain.use_case

import com.example.todolist_.onboarding.domain.repository.IOnboardingRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetNoteDescriptionList @Inject constructor(
    private val onBoardingRepository: IOnboardingRepository
){
    suspend operator fun invoke() = onBoardingRepository.getNoteDescriptionListFromDB()
}
