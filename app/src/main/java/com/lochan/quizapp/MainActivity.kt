package com.lochan.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lochan.quizapp.View.QuizScreen
import com.lochan.quizapp.View.StartScreen
import com.lochan.quizapp.ViewModel.QuizViewModel
import com.lochan.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val quizVM = QuizViewModel()
            QuizAppTheme {
               val navController = rememberNavController()
                NavHost(navController, startDestination = "Start"){
                    composable("Start") {StartScreen(navController,quizVM)}
                    composable("Quiz") {QuizScreen(navController,quizVM)}

                }
            }
        }
    }
}

