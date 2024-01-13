package user_service

import decryption.*

class DecryptionFactory(
    private val communication: Communication,
    private val passwordFinder: PasswordFinder
) {
    fun chooseFileType(): Decryption {
        return when (communication.getTypeOfFile()) {
            "1" -> PDFDecryption(communication, passwordFinder)
            "2" -> ZIPDecryption(communication, passwordFinder)
            "3" -> RARDecryption(communication, passwordFinder)
            else -> throw IllegalArgumentException()
        }
    }
}