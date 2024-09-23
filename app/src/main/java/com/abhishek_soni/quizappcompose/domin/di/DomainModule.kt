package com.abhishek_soni.quizappcompose.domin.di

import com.abhishek_soni.quizappcompose.data.remote.QuizApi
import com.abhishek_soni.quizappcompose.data.repository.QuizRepositoryImpl
import com.abhishek_soni.quizappcompose.domin.repository.QuizRepository
import com.abhishek_soni.quizappcompose.domin.usecases.GetQuizUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    @Singleton
    fun provideGetQuizUseCases(quizRepository: QuizRepository): GetQuizUseCases {
        return GetQuizUseCases(quizRepository)

    }
}