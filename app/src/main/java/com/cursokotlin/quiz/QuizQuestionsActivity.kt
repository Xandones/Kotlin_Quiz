package com.cursokotlin.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // Marks the actual position on quiz (number of the question)
    private var mCurrentPosition : Int = 1

    // This var is used to group all the quiz questions
    private var mQuestionsList : ArrayList<Question>? = null

    // Stores the selected option as an answer for the question
    private var mSelectedOptionPosition : Int = 0

    // Stores the username to show it when the quiz is over
    private var mUserName : String? = null

    // Stores the amount of right answers to compare them with the total amount of questions
    private var mCorrectAnswers : Int = 0

    // Screen elements
    private var progressBar : ProgressBar? = null // The graphic element who indicates the progress (progress bar)
    private var tvProgress : TextView? = null // Two numbers separated by a bar indicating progress (actual progress / total questions)
    private var tvQuestion : TextView? = null // Indicates the number of the question
    private var ivImage : ImageView? = null // This is used to show the images of the flags

    // Options of answers
    private var tvOptionOne : TextView? = null // Option one
    private var tvOptionTwo : TextView? = null // Option two
    private var tvOptionThree : TextView? = null // Option three
    private var tvOptionFour : TextView? = null // Option four

    // Button used to submit data (the answer to each question)
    private var btnSubmit : Button? = null

    // Function executed right on the creation of the object
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        // Stores the username to be used afterwards
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        // Var that connects the visual element to a var (graphical progress bar)
        progressBar = findViewById(R.id.progressBar)

        //  Var that connects the visual element to two var numbers (actual progress / total questions)
        tvProgress = findViewById(R.id.tv_progress)

        // Indicates the actual question that is being shown
        tvQuestion = findViewById(R.id.tv_question)

        // Associates the flag images to a var
        ivImage = findViewById(R.id.iv_image)

        // Associates the available answers to the quiz with a var
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)

        // Associates the visual element button with a var
        btnSubmit = findViewById(R.id.btn_submit)

        // All options bellow are set to null and are waiting if they are selected
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        // The button submit is set to null as standard setting, its state changes when clicked
        btnSubmit?.setOnClickListener(this)

        // Var that stores the questions of the quiz
        mQuestionsList = Constants.getQuestions()

        // Calls the function setQuestion
        setQuestion()
    }

    // The function setQuestion bellow prepares the app elements for use
    private fun setQuestion() {

        // Calls the function defaultOptionsView
        defaultOptionsView()

        // Associates each question to its right position inside the Array List
        val question: Question = mQuestionsList!![mCurrentPosition - 1]

        // Calls the function defaultOptionsView
        defaultOptionsView()

        // Associates the var with the image stored in the folder res / drawable
        ivImage?.setImageResource(question.image)

        // The var progressBar starts as null but receives its data automatically throughout the app from the var mCurrentPosition
        progressBar?.progress = mCurrentPosition

        // The var tvProgress starts as null and receives its data automatically from the vars mCurrentPosition and progressBar with a max modifier for its maximum value
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"

        // Prepares all the elements to be used by the app (the question and four alternatives)
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        // In case of the actual question is the last one the text of the button will be set as "FINISH"
        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "FINISH"
        }

        // Otherwise it will remain as "SUBMIT"
        else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        // Associates all the data of the Array List (the Text Views) to a val named options
        val options = ArrayList<TextView>()

        // All the four options are set the same way: adding it to an Array List with an standard index to each one.
        tvOptionOne?.let {
            options.add(0,it)
        }

        tvOptionTwo?.let {
            options.add(1,it)
        }

        tvOptionThree?.let {
            options.add(2,it)
        }

        tvOptionFour?.let {
            options.add(3,it)
        }

        // The following for sets the look for all the options
        for (option in options) {
            option.setTextColor(Color.parseColor("#7400b8")) // Sets the text color for all options
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            ) // Sets the XML default_option_border_bg to configure visual elements
        }
    }

    // The function bellow sets how the selected option will look
    private fun seletedOptionView(tv : TextView, selectedOptionNum : Int) {

        // Calls the function defaultOptionsView
        defaultOptionsView()

        // The var bellow stores which option was selected
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43")) // Sets the text color
        tv.setTypeface(tv.typeface, Typeface.BOLD) // Sets the font type as bold
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_border_option_bg
        ) // Sets the XML selected_border_option_bg to configure visual elements
    }

    // The function onClick sets what will happen when the user clicks on something
    override fun onClick(view: View?) {

        // This loop refers to all four actions and also to the button (no matter what is written inside the button)
        when (view?.id) {
            // All options are set the same way inside the loop: connecting the visual element to a var and setting a number to it.
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    seletedOptionView(it,1)
                }
            }

            R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    seletedOptionView(it,2)
                }
            }

            R.id.tv_option_three -> {
                tvOptionThree?.let {
                    seletedOptionView(it,3)
                }
            }

            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    seletedOptionView(it,4)
                }
            }

            // Bellow is where the settings for the button are set
            R.id.btn_submit -> {

                // The If will run if its first question
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    // The When loop bellow will work while the question number is smaller or equal to the amount of questions
                    when {

                        // Calls the function setQuestion if the question number is smaller or equal to the amount of questions
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }

                        // The data necessary to end the app will be stored otherwise
                        else -> {
                            val intent = Intent(this, ResultActivity :: class.java)

                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                // If it's not the first question the Else will run
                else {

                    // Stores the right position inside the Array List for each question.
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // The If sets the looks for a wrong selected option through the XML file wrong_option_border_bg
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    // If the answer is right the Else will run and add one to mCorrectAnswers
                    else {
                        mCorrectAnswers++
                    }

                    // In case of a right answer the background will be set according to the XML correct_option_border_bg
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)


                    // If the question is the last one the button text will be set to "FINISH"
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.text = "FINISH"
                    }
                    // Else (in case that the actual question isn't the last one) the text will be set to "GO TO THE NEXT QUESTION"
                    else {
                        btnSubmit?.text = "GO TO THE NEXT QUESTION"
                    }

                    // Resets the selected position after the answer is already computed
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    // The function bellow sets the behavior of the answers calling itself again to implement looks when needed
    private fun answerView (answer : Int, drawableView : Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }

        }
    }
}