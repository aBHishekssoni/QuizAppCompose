package com.abhishek_soni.quizappcompose.presentation.quiz

import com.abhishek_soni.quizappcompose.domin.model.Quiz

data class StateQuizScreen (
    val isLoading: Boolean = false,
    val quizState: List<QuizState> = emptyList(),
    val error: String="",
    val score:Int= 0

)

data class QuizState(
    val quiz: Quiz?=null,
    val shuffledOptions: List<String> =emptyList(),
    val selectedOption: Int?=-1
)