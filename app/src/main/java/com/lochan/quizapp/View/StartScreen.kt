package com.lochan.quizapp.View

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.lochan.quizapp.ViewModel.QuizViewModel

@Composable
fun StartScreen(navController: NavController,quizViewModel: QuizViewModel) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Button(onClick = {
            navController.navigate("Quiz")
            //Start the Quiz Logic
            quizViewModel.resetQuiz()
        }) {
            Text("Start Quiz")
        }
    }
}