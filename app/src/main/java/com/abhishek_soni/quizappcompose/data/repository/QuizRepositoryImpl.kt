package com.abhishek_soni.quizappcompose.data.repository

import com.abhishek_soni.quizappcompose.data.remote.QuizApi
import com.abhishek_soni.quizappcompose.domin.model.Quiz
import com.abhishek_soni.quizappcompose.domin.repository.QuizRepository

class QuizRepositoryImpl(
    private val quizApi: QuizApi
): QuizRepository {
    override suspend fun geiQuizzes(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Quiz> {
        return quizApi.getQuizzes(amount, category, difficulty, type).results
    }

}