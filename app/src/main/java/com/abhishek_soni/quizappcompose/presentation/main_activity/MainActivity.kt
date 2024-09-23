package com.abhishek_soni.quizappcompose.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.abhishek_soni.quizappcompose.R
import com.abhishek_soni.quizappcompose.presentation.home.HomeScreen
import com.abhishek_soni.quizappcompose.presentation.home.HomeViewModel
import com.abhishek_soni.quizappcompose.presentation.nav_graph.SetNavGraph
import com.abhishek_soni.quizappcompose.ui.theme.QuizAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            QuizAppComposeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.mid_night_blue)),
                            contentAlignment = Alignment.Center
                    ) {
                        SetNavGraph()
                    }
                }
            }
        }
    }
}
