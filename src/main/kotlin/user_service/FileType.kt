package user_service

import decryption.Decryption
import decryption.PDFDecryption
import decryption.PasswordFinder

class DecryptionFactory(
    private val communication: Communication,
    private val passwordFinder: PasswordFinder
) {
    fun chooseFileType(): Decryption {
        return when (communication.getTypeOfFile()) {
            "1" -> PDFDecryption(communication, passwordFinder)
            "2" -> PDFDecryption(communication, passwordFinder)
            "3" -> PDFDecryption(communication, passwordFinder)
            else -> throw IllegalArgumentException()
        }
    }
}