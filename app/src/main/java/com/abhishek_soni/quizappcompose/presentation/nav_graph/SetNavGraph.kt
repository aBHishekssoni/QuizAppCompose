package com.abhishek_soni.quizappcompose.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abhishek_soni.quizappcompose.presentation.home.HomeScreen
import com.abhishek_soni.quizappcompose.presentation.home.HomeViewModel
import com.abhishek_soni.quizappcompose.presentation.quiz.QuizScreen
import com.abhishek_soni.quizappcompose.presentation.quiz.QuizViewModel
import com.abhishek_soni.quizappcompose.presentation.score.ScoreScreen

@Composable
fun SetNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = Routes.HomeScreen.route){
        composable(route = Routes.ScoreScreen.route,
            arguments = listOf(
                navArgument(NOQ_KEY){type = NavType.IntType},
                navArgument(CORRECT_ANS_KEY){type = NavType.IntType}
            ),
        ){
                val numOfQuestions = it.arguments?.getInt(NOQ_KEY)
                val numOfCorrectAns = it.arguments?.getInt(CORRECT_ANS_KEY)
                ScoreScreen(
                    numOfQuestions = numOfQuestions!!,
                    numOfCorrectAns = numOfCorrectAns!!,
                    navController = navController
                )

            }

        composable(route = Routes.HomeScreen.route){
            val ViewModel: HomeViewModel = hiltViewModel()
            val state by ViewModel.homestate.collectAsState()
            HomeScreen(
                state = state,
                event = ViewModel::onEvent,
                navController = navController
            )
        }
        composable(route = Routes.QuizScreen.route,
            arguments = listOf(
                navArgument(ARG_QUIZ_NUMBER){type = NavType.IntType},
                navArgument(ARG_QUIZ_CATEGORY){type = NavType.StringType},
                navArgument(ARG_QUIZ_DIFFICULTY){type = NavType.StringType},
                navArgument(ARG_QUIZ_TYPE){type = NavType.StringType}
            )
            ){
            val numofQuizzes = it.arguments?.getInt(ARG_QUIZ_NUMBER)
            val quizCategory = it.arguments?.getString(ARG_QUIZ_CATEGORY)
            val quizDifficulty = it.arguments?.getString(ARG_QUIZ_DIFFICULTY)
            val quizType = it.arguments?.getString(ARG_QUIZ_TYPE)

            val ViewModel: QuizViewModel = hiltViewModel()
            val state by ViewModel.quizList.collectAsState()
            QuizScreen(
                numofQuiz = numofQuizzes!!,
                quizCategory = quizCategory!!,
                quizDifficulty = quizDifficulty!!,
                quizType = quizType!!,
                event = {ViewModel.onEvent(it)},
                state = state,
                navController = navController
            )

        }
    }
}