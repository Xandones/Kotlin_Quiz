package com.cursokotlin.quiz

/*
    This Kotlin file defines all the variables that are supposed to be used through all the project.
    Since its values won't change throughout the project they are all declared using "val".
 */
data class Question(
    // The ID val is used for a faster access to each question, identifying them.
    val id : Int,

    // The Question val is used to define the question. In this case the question is always the same.
    val question : String,

    // The Image val is used to define the image of the flag that will be used on the question.
    val image : Int,

    // The following vals are used to define the possible countries to answer the question.
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,

    // This val defines the right answer to the question defined using the ID.
    val correctAnswer : Int
)
