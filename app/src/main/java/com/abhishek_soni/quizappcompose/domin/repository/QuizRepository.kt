package com.abhishek_soni.quizappcompose.domin.repository

import com.abhishek_soni.quizappcompose.domin.model.Quiz

interface QuizRepository {
    suspend fun geiQuizzes(amount: Int, category: Int, difficulty: String, type: String): List<Quiz>
}