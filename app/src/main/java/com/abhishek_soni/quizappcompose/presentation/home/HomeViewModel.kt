package com.abhishek_soni.quizappcompose.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    private val _homestate = MutableStateFlow(StateHomeScreen())
    val homestate = _homestate

    fun onEvent(event: EventHomeScreen) {
        when (event) {
            is EventHomeScreen.SetNumberofQuizzes -> {
                _homestate.value = homestate.value.copy(numberofQuizzes = event.numberofQuizzes.toInt())
            }

            is EventHomeScreen.SetQuizCategory ->     {
                _homestate.value = homestate.value.copy(category = event.category)

            }
                is EventHomeScreen.SetQuizDifficulty ->{
                    _homestate.value = homestate.value.copy(difficulty = event.difficulty)

                }
            is EventHomeScreen.SetQuizType -> {
                _homestate.value = homestate.value.copy(type = event.type)

            }
                else -> {}
        }
    }
}