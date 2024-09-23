package com.abhishek_soni.quizappcompose.presentation.nav_graph

import android.text.TextUtils.replace


const val ARG_QUIZ_NUMBER = "ak_quiz_number"
const val ARG_QUIZ_CATEGORY = "ak_quiz_category"
const val ARG_QUIZ_DIFFICULTY = "ak_quiz_difficulty"
const val ARG_QUIZ_TYPE = "ak_quiz_type"
const val NOQ_KEY = "noq_key"
const val CORRECT_ANS_KEY = "correct_ans_key"

sealed class Routes(val route: String) {
    object HomeScreen : Routes("home_screen")
    object QuizScreen : Routes("quiz_screen/{$ARG_QUIZ_NUMBER}/{$ARG_QUIZ_CATEGORY}/{$ARG_QUIZ_DIFFICULTY}/{$ARG_QUIZ_TYPE}"){

        fun passQuizParams(numofQuizzes: Int,category: String,difficulty: String,type: String): String {
            return "quiz_screen/{$ARG_QUIZ_NUMBER}/{$ARG_QUIZ_CATEGORY}/{$ARG_QUIZ_DIFFICULTY}/{$ARG_QUIZ_TYPE}"

                .replace(oldValue="{$ARG_QUIZ_NUMBER}",
                    newValue = numofQuizzes.toString(),
                )
                .replace(oldValue="{$ARG_QUIZ_CATEGORY}",
                    newValue = category,
                )
                .replace(oldValue="{$ARG_QUIZ_DIFFICULTY}",
                    newValue = difficulty,
                )
                .replace(oldValue="{$ARG_QUIZ_TYPE}",
                    newValue = type,
                )


        }
    }
    object ScoreScreen : Routes("score_screen/{$NOQ_KEY}/{$CORRECT_ANS_KEY}"){
        fun passNunOfQuestionsAndCorrectAns(questions: Int,correctAns: Int): String {
            return "score_screen/{$NOQ_KEY}/{$CORRECT_ANS_KEY}"
                .replace( "{$NOQ_KEY}",questions.toString())
                .replace( "{$CORRECT_ANS_KEY}",correctAns.toString())
        }
    }
}