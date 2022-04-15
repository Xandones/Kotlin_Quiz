package com.cursokotlin.quiz

// Here the class Constants is declared and instanced at the same time.
object Constants {

    // This val stores the username informed on login screen. It can't be changed while playing.
    const val USER_NAME : String = "user_name"

    /* The total number of questions is stored here. It is informed at QuizQuestionsActivity.kt
       It can't be changed because it's the size of the array of questions.
       It's a string to facilitate displaying. */
    const val TOTAL_QUESTIONS : String = "total_questions"

    // The amount of right answers is stored here. It's a string to facilitate displaying.
    const val CORRECT_ANSWERS : String = "correct_answers"

    /* The function getQuestions sets every question including its alternatives and its right answer.
       Here is also set a image of a flag to each question. In this project there are 15 questions. */
    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, // Here is where the flag images are set.
            "Argentina", "Australia", "Armenia", "Austria",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina", "Australia", "Armenia", "New Zealand",
            4
        )
        questionsList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina", "Belgium", "Armenia", "Austria",
            2
        )
        questionsList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil", "Australia", "Armenia", "Austria",
            1
        )
        questionsList.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina", "Australia", "Denmark", "Austria",
            3
        )
        questionsList.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina", "Australia", "Fiji", "Austria",
            3
        )
        questionsList.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Australia", "Armenia", "Austria",
            1
        )
        questionsList.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentina", "India", "Armenia", "Austria",
            2
        )
        questionsList.add(que8)

        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina", "Australia", "Kuwait", "Austria",
            3
        )
        questionsList.add(que9)

        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.canada,
            "France", "Australia", "Switzerland", "Canada",
            4
        )
        questionsList.add(que10)

        val que11 = Question(
            11, "What country does this flag belong to?",
            R.drawable.eua,
            "Russia", "USA", "France", "Canada",
            2
        )
        questionsList.add(que11)

        val que12 = Question(
            12, "What country does this flag belong to?",
            R.drawable.jamaica,
            "Jamaica", "South Africa", "Nigeria", "Canada",
            1
        )
        questionsList.add(que12)

        val que13 = Question(
            13, "What country does this flag belong to?",
            R.drawable.ukraine,
            "France", "Australia", "Switzerland", "Ukraine",
            4
        )
        questionsList.add(que13)

        val que14 = Question(
            14, "What country does this flag belong to?",
            R.drawable.israel,
            "Brazil", "India", "Switzerland", "Israel",
            4
        )
        questionsList.add(que14)

        val que15 = Question(
            15, "What country does this flag belong to?",
            R.drawable.japan,
            "China", "Japan", "Vietnam", "South Korea",
            2
        )
        questionsList.add(que15)

        // The function returns an Array List with all the 15 questions.
        return questionsList
    }
}