package com.cursokotlin.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

// Declares the class ResultActivity as one of AppCompatActivity type
class ResultActivity : AppCompatActivity() {

    // The function onCreate does things right on the instancing of an object.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The visual elements are defined in activity_result.xml
        setContentView(R.layout.activity_result)

        // This vals connect the Text Views with the rest of the code of the project.
        val tvName : TextView = findViewById(R.id.tv_name)
        val tvScore : TextView = findViewById(R.id.tv_score)

        // This val connect the visual element Button with the rest of the code of the project.
        val btnFinish : Button = findViewById(R.id.btn_finish)

        // Links the val tvName to the constant USER_NAME
        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        // Links the val totalQuestions to the constant TOTAL_QUESTIONS
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        // Links the val correctAnswers to the constant CORRECT_ANSWERS
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        /* Sets a phrase to the val tvScore where is shown the amount of right answers an also
           the amount of questions that were asked (15) */
        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"

        // Here the button btnFinish is connected to MainActivity.kt
        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity :: class.java))
        }
    }
}