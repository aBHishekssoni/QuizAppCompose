package com.abhishek_soni.quizappcompose.presentation.home

data class StateHomeScreen (
    val numberofQuizzes: Int = 10,
    val category: String = "General Knowledge",
    val difficulty: String = "Easy",
    val type: String = "Multiple Choice"

)