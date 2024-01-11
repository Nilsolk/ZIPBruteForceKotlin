class Main {
    fun start() {

    }
}

class Communication {
    fun chooseAlphabet(): Boolean {
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
        val length = readln()
        return try {
            length.toInt()
        } catch (e: TypeCastException) {
            println(e.message + "Not number,try again")
            getLength()
        }
    }

    fun getPath(): String {
        val path = readln()
        if (path.isEmpty()) {
            println("Empty directory, try again")
            getPath()
        }
        return path
    }
}

