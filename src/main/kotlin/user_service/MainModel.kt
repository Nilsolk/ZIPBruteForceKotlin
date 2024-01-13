package user_service

import decryption.PasswordFinder
import kotlin.system.exitProcess

class MainModel {
    fun start() {
        greetings()
        val communication = Communication()
        val passwordFinder = PasswordFinder()

        try {
            val decryption = DecryptionFactory(communication, passwordFinder).chooseFileType()
            decryption.decode()
        } catch (e: IllegalArgumentException) {
            println("Wrong input, try again")
            exitProcess(1)
        }
    }

    private fun greetings() {
        println(
            "Hello, it`s simple brute force program." +
                    "\n If you need to hack: PDF type - 1, ZIP type - 2, RAR type - 3" +
                    "\n You can use inner characters or type your own alphabet"
        )
    }
}


fun main() {
    val mainModel = MainModel()
    mainModel.start()
}



