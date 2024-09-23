package com.abhishek_soni.quizappcompose.presentation.quiz

import androidx.compose.runtime.mutableStateOf

sealed class EventQuizScreen {
    data class GetQuizzes(val numofQuizzes: Int, val category: Int, val difficulty: String, val type: String) : EventQuizScreen()

    data class SetOptionSelected(val quizStateIndex: Int, val selectedOption: Int) : EventQuizScreen()
}