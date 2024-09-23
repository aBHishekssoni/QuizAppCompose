package com.abhishek_soni.quizappcompose.data.remote.dto

import com.abhishek_soni.quizappcompose.domin.model.Quiz

data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
)