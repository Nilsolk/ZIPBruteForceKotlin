package decryption

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException
import user_service.Communication
import java.io.File


class PDFDecryption(
    communication: Communication,
    private val finder: PasswordFinder
) : Decryption(communication) {

    override fun decode() {
        var password = String(CharArray(passwordLength) { letters[0] })
        while (true) {
            println(password)
            try {
                val file = File(path)
                val document = PDDocument.load(file, password)
                println("Ваш пароль -> $password")
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




