class Main {
    fun start() {

    }
}

private const val URL = ""

class Decryption(private val communication: Communication) {


    private val letters: String = when (communication.chooseAlphabet()) {
        true -> "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$%^&*()_\\-+=[{]}|:;'\",<.>/?"
        false -> {
            println("Type your own letters below,without spaces")
            readln()
        }
    }
    private val passwordLength = communication.getLength()

    fun decrypt(path: String) {

    }
}


class Communication {
    fun chooseAlphabet(): Boolean {
        val userChoice = readln()
        return when (userChoice) {
            "1" -> true
            "2" -> false
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
}

class Messages {
    fun greetings() {
        println("Hello, it`s simple brute force program.\nYou can use inner characters or type your own alphabet below")
    }

    fun chooseLetters() {
        println("If you want use inner characters type 1, else type 2")
    }

    fun length() {
        println("Enter length of password")
    }
}
