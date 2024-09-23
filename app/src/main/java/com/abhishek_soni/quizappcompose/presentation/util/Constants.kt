package com.abhishek_soni.quizappcompose.presentation.util

object Constants {
    val numberAsString= listOf("10")+(1..50).map { it.toString() }
    val categories = listOf(
        "General Knowledge",
        "Entertainments: Books",
        "Entertainments: Film",
        "Entertainments: Music",
        "Entertainments: Musicals & Theatres",
        "Entertainments: Television",
        "Entertainments: Video Games",
        "Entertainments: Board Games",
        "Science & Nature",
        "Science: Computers",
        "Science: Mathematics",
        "Mythology",
        "Sports",
        "Geography",
        "History",
        "Politics",
        "Art",
        "Celebrities",
        "Animals",
        "Vehicles",
    )
    val categoriesMap = mapOf(
        "General Knowledge" to 9,
        "Entertainments: Books" to 10,
        "Entertainments: Film" to 11,
        "Entertainments: Music" to 12,
        "Entertainments: Musicals & Theatres" to 13,
        "Entertainments: Television" to 14,
        "Entertainments: Video Games" to 15,
        "Entertainments: Board Games" to 16,
        "Science & Nature" to 17,
        "Science: Computers" to 18,
        "Science: Mathematics" to 19,
        "Mythology" to 20,
        "Sports" to 21,
        "Geography" to 22,
        "History" to 23,
        "Politics" to 24,
        "Art" to 25,
        "Celebrities" to 26,
        "Animals" to 27,
        "Vehicles" to 28,
    )
    val difficulty = listOf("easy", "medium", "hard")
    val type = listOf("multiple", "TureORFalse")
}