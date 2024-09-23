package com.abhishek_soni.quizappcompose.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.abhishek_soni.quizappcompose.presentation.common.AppDropDownMenu
import com.abhishek_soni.quizappcompose.presentation.common.ButtonBox
import com.abhishek_soni.quizappcompose.presentation.home.Component.HomeHeader
import com.abhishek_soni.quizappcompose.presentation.nav_graph.Routes
import com.abhishek_soni.quizappcompose.presentation.util.Constants
import com.abhishek_soni.quizappcompose.presentation.util.Dimens.MediumPadding
import com.abhishek_soni.quizappcompose.presentation.util.Dimens.MediumSpaceHeight
import com.abhishek_soni.quizappcompose.presentation.util.Dimens.SmallSpaceHeight


//@Preview
//@Composable
//private fun HomeScreenPreview() {
//    HomeScreen(state = StateHomeScreen()
////    event = {}
//    )
//}

@Composable
fun HomeScreen(
    state: StateHomeScreen,
    event: (EventHomeScreen) -> Unit = {},
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        HomeHeader()

        Spacer(modifier = Modifier.height(MediumSpaceHeight))
        AppDropDownMenu(menuName = "Number of Questions:", menuList = Constants.numberAsString ,text = state.numberofQuizzes.toString(),onDropDownClick = {event(EventHomeScreen.SetNumberofQuizzes(it))})

        Spacer(modifier = Modifier.height(SmallSpaceHeight))
        AppDropDownMenu(menuName = "Select Category:", menuList = Constants.categories,text = state.category,onDropDownClick = {event(EventHomeScreen.SetQuizCategory(it))})

        Spacer(modifier = Modifier.height(SmallSpaceHeight))
        AppDropDownMenu(menuName = "Select Difficulty:", menuList = Constants.difficulty,text = state.difficulty,onDropDownClick = {event(EventHomeScreen.SetQuizDifficulty(it))})

        Spacer(modifier = Modifier.height(SmallSpaceHeight))
        AppDropDownMenu(menuName = "Select Type:", menuList = Constants.type,text = state.type,onDropDownClick = {event(EventHomeScreen.SetQuizType(it))})

        Spacer(modifier = Modifier.height(MediumSpaceHeight))

        ButtonBox(text = "Generate Quiz", padding = MediumPadding){
//            Log.d("quiz detail","${state.numberofQuizzes} ${state.category} ${state.difficulty} ${state.type}")
            navController.navigate(Routes.QuizScreen.passQuizParams(state.numberofQuizzes,state.category,state.difficulty,state.type))

        }
    }
}