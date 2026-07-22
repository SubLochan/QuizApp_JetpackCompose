package com.lochan.quizapp.ViewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizViewModel(private val repository: QuizRepository = QuizRepository()) : ViewModel() {
    private val questions = repository.getAllQuestions()

    var currentIndex by mutableStateOf(0)
        private set

    var currentQuestion by mutableStateOf(questions[0])
        private set

    var timerValue by mutableStateOf(10)
        private set

    var quizFinished by mutableStateOf(false)
        private set

    var score by mutableStateOf(0)
        private set

    private var timerJob : Job? = null

    val totalQuestions : Int
        get() = questions.size

    fun startTimer(){
       timerJob = viewModelScope.launch {
            while(timerValue > 0){
                delay(1000)
                timerValue--
            }
            //timer = 0
            //finish Quiz
           finishQuiz()

        }
    }

    fun answerQuestion(userAnswer: Boolean){
        timerJob?.cancel()
        if(userAnswer == currentQuestion.answer){
            score++
        }
        currentIndex++
        if(currentIndex < questions.size){
            // move to next Que
            startNewQuestion()
        }
        else{
            // finish the Quiz
            finishQuiz()
        }
    }

    fun resetQuiz(){
        currentIndex = 0
        score = 0
        quizFinished = false
        // start a new Question
        startNewQuestion()
    }


    fun finishQuiz(){
        timerJob?.cancel()
        quizFinished = true
    }

    fun startNewQuestion(){
        timerJob?.cancel()
        timerValue = 10
        if(currentIndex < questions.size){
            currentQuestion = questions[currentIndex]
        }
        else{
            quizFinished = true
        }
    }
}