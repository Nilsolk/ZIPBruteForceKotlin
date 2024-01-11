package common

class Printer {

    fun printMessage(message: String) = println(message)

    companion object {
        private val STRINGS =
            mutableListOf(
                "Hello, it`s simple brute force program.\nYou can use inner characters or type your own alphabet below",
                "If you want use inner characters type y, else type n",
                "Enter length of password",
                "Enter path to your secret zip file",
                "Enter path to your destination directory"
            )
        private val RESULT_STRINGS = mutableListOf(
            mutableListOf(
                "Files successfully extracted",
                "Error, something went wrong"
            )
        )
    }
}