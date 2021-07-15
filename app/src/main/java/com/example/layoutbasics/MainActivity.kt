package com.example.layoutbasics

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.dynamic_layout.*

const val margin: Int = 16

//extension property to convert dp into pixel
val Int.pixel: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

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

    private fun setupTextQuestion(counter: Int, q: Question){
        val textView = getQuestionTextView(counter, q.qText)

        val editText = EditText(this)
        editText.setSingleLine(true)
        editText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        quiz_container.addView(textView)
        quiz_container.addView(editText)
    }

    private fun setupRadioQuestion(counter: Int, q:Question){}

    private fun setupCheckBoxQuestion(counter: Int, q:Question){}

    private fun getQuestionTextView(counter: Int, question: String): TextView{
        val textView = TextView(this)
        textView.text = "Q{counter}. {question}"

        // For the TextView we are setting these layout parameters
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = margin.pixel}

        return textView
    }




}