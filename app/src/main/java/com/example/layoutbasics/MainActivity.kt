package com.example.layoutbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var questions: MutableList<Question> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //setContentView(R.layout.mixed)
        setContentView(R.layout.dynamic_layout)

        setupQuestions()
        setupQuiz()

    }

    private fun setupQuestions(){
        questions.add(Question(1, QuestionType.Text, "What is the capital of Nagaland?", null, listOf("kohima")))
        questions.add(Question(2, QuestionType.Radio,"Which is the largest(area) state in India?",
            listOf("Bihar", "Madhya Pradesh", "Uttar Pradesh", "Rajasthan"), listOf("Rajasthan")))
        questions.add(Question(3, QuestionType.Checkbox, "Which of these are state capitals?",
            listOf("Guwahati","Chennai","Vanarasi","Dispur"), listOf("Chennai","Dispur")))
    }

    private fun setupQuiz(){
        questions.forEachIndexed{ index, element ->
            when(element.type){
                QuestionType.Text ->{
                    setupTextQuestion(index, element)
                }
                QuestionType.Radio ->{
                    setupRadioQuestion(index, element)
                }
                QuestionType.Checkbox ->{
                    setupCheckBoxQuestion(index, element)
                }
            }
        }
    }

    private fun setupTextQuestion(counter: Int, q: Question){}
    private fun setupRadioQuestion(counter: Int, q:Question){}
    private fun setupCheckBoxQuestion(counter: Int, q:Question){}

}