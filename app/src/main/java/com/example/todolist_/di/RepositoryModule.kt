package com.example.todolist_.di

import com.example.todolist_.local.IOnboardingDao
import com.example.todolist_.onboarding.data.local.IOnboardingLocalDataSource
import com.example.todolist_.onboarding.data.local.OnBoardingLocalDataSource
import com.example.todolist_.onboarding.domain.repository.IOnboardingRepository
import com.example.todolist_.onboarding.domain.repository.OnBoardingRepository
import com.example.todolist_.onboarding.mapper.NoteCardMapper
import com.example.todolist_.onboarding.mapper.NoteDescriptionDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideOnBoardingRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        localDataSource: IOnboardingLocalDataSource,
        noteCardMapper: NoteCardMapper,
        noteDescriptionDataMapper: NoteDescriptionDataMapper
    ): IOnboardingRepository {
        return OnBoardingRepository(ioDispatcher, localDataSource, noteCardMapper, noteDescriptionDataMapper)
    }
}



