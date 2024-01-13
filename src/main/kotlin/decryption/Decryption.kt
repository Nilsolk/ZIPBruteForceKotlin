package decryption

import user_service.Communication

abstract class Decryption(
    private val communication: Communication,
) : Decoder {
    protected val passwordLength = communication.getLength()
    protected val letters: CharArray = when (communication.chooseAlphabet()) {
        true -> "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
        false -> {
            println("Type your own characters below, without spaces")
            readln().toCharArray()
        }
    }
    protected val path = communication.getPath()
}

interface Decoder {
    fun decode()
}