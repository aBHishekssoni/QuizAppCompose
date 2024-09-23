package com.abhishek_soni.quizappcompose.presentation.quiz

import com.abhishek_soni.quizappcompose.presentation.quiz.EventQuizScreen
import com.abhishek_soni.quizappcompose.presentation.quiz.QuizState
import com.abhishek_soni.quizappcompose.presentation.quiz.StateQuizScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek_soni.quizappcompose.common.Resource
import com.abhishek_soni.quizappcompose.domin.model.Quiz
import com.abhishek_soni.quizappcompose.domin.repository.QuizRepository
import com.abhishek_soni.quizappcompose.domin.usecases.GetQuizUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val getQuizUseCases: GetQuizUseCases) : ViewModel() {

    private val _quizList = MutableStateFlow(StateQuizScreen())
    val quizList = _quizList

    fun onEvent(event: EventQuizScreen) {
        when (event) {
            is EventQuizScreen.GetQuizzes -> {
                getQuizzes(event.numofQuizzes, event.category, event.difficulty, event.type)
            }

            is EventQuizScreen.SetOptionSelected -> {
                updateQuizStateList(event.quizStateIndex, event.selectedOption)
            }
        }
    }

    private fun updateQuizStateList(quizStateIndex: Int, selectedOption: Int) {
        val updatedQuizStateList = mutableListOf<QuizState>()
        quizList.value.quizState.forEachIndexed { index, quizState ->
            updatedQuizStateList.add(
                if (quizStateIndex == index) {
                    quizState.copy(selectedOption = selectedOption)
                } else {
                    quizState

                }
            )
        }
        _quizList.value = _quizList.value.copy(quizState = updatedQuizStateList)

        updateScore(_quizList.value.quizState[quizStateIndex])

    }

    private fun updateScore(quizState: QuizState) {
        if (quizState.selectedOption!=-1){
            val correctAnswer = quizState.quiz?.correct_answer
            val selectedAnswer = quizState.selectedOption?.let { quizState.shuffledOptions[it] .replace("&quot;", "\"").replace("&#039;", "\'")}

            if(correctAnswer == selectedAnswer){
                val previousScore = _quizList.value.score
                _quizList.value = _quizList.value.copy(score = previousScore+1)
            }
        }

    }


    private fun getQuizzes(amount: Int, category: Int, difficulty: String, type: String) {
        viewModelScope.launch {

            getQuizUseCases(amount, category, difficulty, type).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _quizList.value = StateQuizScreen(isLoading = true)
                    }

                    is Resource.Success -> {
                        val lisofQuizState: List<QuizState> = getListOfQuizState(resource.data)
                        _quizList.value = StateQuizScreen(quizState = lisofQuizState)
                    }

                    is Resource.Error -> {
                        _quizList.value = StateQuizScreen(error = resource.message.toString())

                    }
                }
            }
        }
    }

    private fun getListOfQuizState(data: List<Quiz>?): List<QuizState> {
        val listOfQuizState = mutableListOf<QuizState>()
        for (quiz in data!!) {
            val shuffledOptions = mutableListOf<String>().apply {
                add(quiz.correct_answer)
                addAll(quiz.incorrect_answers)
                shuffle()
            }

            listOfQuizState.add(QuizState(quiz, shuffledOptions, -1))
        }
        return listOfQuizState
    }

}


