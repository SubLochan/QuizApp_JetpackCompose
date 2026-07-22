package com.lochan.quizapp.ViewModel

import com.lochan.quizapp.Model.Question

class QuizRepository {
    // get questions from web , DB ,cloud ,etc.
    private val questions = listOf(
        Question("CPU stands for Central Processing Unit.", true),
        Question("RAM is a type of permanent storage.", false),
        Question("Java is an object-oriented programming language.", true),
        Question("HTML is a programming language.", false),
        Question("The binary number system uses only 0 and 1.", true),
        Question("A compiler translates source code into machine code.", true),
        Question("HTTP stands for HyperText Transfer Protocol.", true),
        Question("SQL is primarily used for image editing.", false),
        Question("The Internet and the World Wide Web are the same thing.", false),
        Question("C++ supports object-oriented programming.", true)
    )
    fun getAllQuestions(): List<Question> = questions
}