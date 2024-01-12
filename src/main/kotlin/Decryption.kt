import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException
import java.io.File


class Decryption(
    private val communication: Communication, private val finder: PasswordFinder
) {
    private val passwordLength = communication.getLength()
    private val letters: CharArray = when (communication.chooseAlphabet()) {
        true -> "1234567890".toCharArray()
        false -> {
            println("Type your own characters below, without spaces")
            readln().toCharArray()
        }
    }

    fun isPasswordCorrect(rarFilePath: String, initialPassword: String = String(CharArray(passwordLength) { letters[0] })) {
        var password = initialPassword
        while (true) {
            println(password)
            try {
                val file = File(rarFilePath)
                val document = PDDocument.load(file, password)
                println("PDF-файл открыт успешно.")
                document.close()
                break
            } catch (e: InvalidPasswordException) {
                val newPassword = finder.findCombinationOfPassword(password.toCharArray(), letters)
                password = String(newPassword)
            } catch (e: Exception) {
                println("something went wrong, try again" + " ${e.message} + ${e.cause} + $e")
                break
            }
        }
    }

}




