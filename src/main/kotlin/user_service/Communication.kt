package user_service

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

    fun getPath(): String {
        println("Enter path to your file")
        val path = readln()
        if (path.isEmpty()) {
            println("Empty directory, try again")
            getPath()
        }
        return path
    }

    fun getTypeOfFile(): String {
        println("If you need to hack: PDF type - 1, ZIP type - 2, RAR type - 3")
        return readln()
    }

}