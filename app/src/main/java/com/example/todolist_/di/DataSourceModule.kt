package com.example.todolist_.di

import com.example.todolist_.local.ToDoListDao
import com.example.todolist_.onboarding.data.local.IOnboardingLocalDataSource
import com.example.todolist_.onboarding.data.local.OnBoardingLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideOnboardingLocalDataSource(
        dao: ToDoListDao
    ): IOnboardingLocalDataSource {
        return OnBoardingLocalDataSource(
            dao
        )
    }
}