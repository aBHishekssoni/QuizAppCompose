package com.abhishek_soni.quizappcompose.presentation.home

sealed class EventHomeScreen {
    data class SetNumberofQuizzes(val numberofQuizzes: String) : EventHomeScreen()
    data class SetQuizCategory(val category: String) : EventHomeScreen()
    data class SetQuizDifficulty(val difficulty: String) : EventHomeScreen()
    data class SetQuizType(val type: String) :EventHomeScreen()
}