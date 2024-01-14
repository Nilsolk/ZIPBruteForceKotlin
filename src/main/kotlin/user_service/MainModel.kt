package user_service

import decryption.PasswordFinder
import kotlin.system.exitProcess

class MainModel {
    fun start() {
        greetings()
        try {
            val decryption = DecryptionFactory(Communication(), PasswordFinder()).chooseFileType()
            decryption.decode()
        } catch (e: IllegalArgumentException) {
            println("Wrong input, try again")
            exitProcess(1)
        }
    }

    private fun greetings() {
        println(
            "Hello, it`s simple brute force program." +
                    "\nIf you need to hack PDF, ZIP and RAR files" +
                    "\nYou can use inner characters or type your own alphabet"
        )
    }
}


fun main() {
    val mainModel = MainModel()
    mainModel.start()
}








