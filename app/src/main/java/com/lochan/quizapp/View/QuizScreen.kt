package com.lochan.quizapp.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.lochan.quizapp.ViewModel.QuizViewModel

@Composable
fun QuizScreen(navController: NavController, quizViewModel: QuizViewModel) {

    // 1st UI ==> Alert
    if (quizViewModel.quizFinished) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("Quiz Finished") },
            text = { Text("Your Score is ${quizViewModel.score} / ${quizViewModel.totalQuestions}") },
            confirmButton = {
                Button(onClick = { navController.popBackStack() }) {
                    Text("OK")
                }
            }
        )

    }
    // 2nd UI ==> The Quiz UI
    else{

        LaunchedEffect(quizViewModel.currentQuestion) {
            quizViewModel.startTimer()
        }

        Column(modifier = Modifier.fillMaxSize().padding(10.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("Time Left ${quizViewModel.timerValue}s", style = MaterialTheme.typography.bodyLarge)
            LinearProgressIndicator(
                progress = quizViewModel.timerValue/10f,
                modifier = Modifier.fillMaxWidth().height(8.dp)
            )
            Text(
                quizViewModel.currentQuestion.text , style = MaterialTheme.typography.bodyLarge
            )
            Row(){
                Button(onClick = {
                    quizViewModel.answerQuestion(true)
                }) {
                    Text("True")
                }
                Button(onClick = {
                    quizViewModel.answerQuestion(false)
                }) {
                    Text("False")
                }
            }
        }
    }


}