package com.cursokotlin.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// Declares the class MainActivity as one of AppCompatActivity type
class MainActivity : AppCompatActivity() {

    // The function onCreate does things right on the instancing of an object.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The visual elements are defined in activity_main.xml
        setContentView(R.layout.activity_main)

        // Connects the Button btnStart to the visual element in activity_main.xml
        val btnStart : Button = findViewById(R.id.btn_start)

        // Connects the Edit Text etName to the visual element in activity_main.xml
        val etName : EditText = findViewById(R.id.et_name)

        // The setOnClickListener sets the btnStart
        btnStart.setOnClickListener {

            // If the field is empty it shows a Toast asking to fill it.
            if (etName.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_LONG).show()
            }

            // Otherwise it starts the app.
            else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)

                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}