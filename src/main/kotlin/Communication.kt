class Communication {


    fun chooseAlphabet(): Boolean {
        println("If you want use inner characters type y, else type n")
        val userChoice = readln()
        return when (userChoice) {
            "y" -> true
            "n" -> false
            else -> {
                println("Incorrect data, try again")
                chooseAlphabet()
            }
        }
    }

    fun getLength(): Int {
        println("Enter length of password")
        val length = readln()
        return try {
            length.toInt()
        } catch (e: TypeCastException) {
            println(e.message + "Not number,try again")
            getLength()
        }
    }

    fun getPath(str: String): String {
        val path = readln()
        if (path.isEmpty()) {
            println("Empty directory, try again")
            getPath(str)
        }
        return path
    }

}