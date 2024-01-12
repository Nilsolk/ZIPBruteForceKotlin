import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException
import java.io.File


class Decryption(
    private val communication: Communication, private val finder: PasswordFinder
) {
    private val passwordLength = communication.getLength()
    private val letters: CharArray = when (communication.chooseAlphabet()) {
        true -> "1234567890".toCharArray()
        //`~!@#$%^&*()_\\-+=[{]}|:;'\",<.>/?"
        false -> {
            println("Type your own characters below, without spaces")
            readln().toCharArray()
        }
    }


    fun isPasswordCorrect(
        rarFilePath: String, password: String = String(CharArray(passwordLength) { letters[0] }), passwordCount: Int = 1
    ) {

        println(password)
//            val rarFile = File(rarFilePath)
//            val archive = Archive(rarFile, password)
//            println("Success password is -> $password")
//            archive.close()
        try {
            val file = File(rarFilePath)
            val document = PDDocument.load(file, password)
            println("PDF-файл открыт успешно.")
            document.close()

//            } catch (e: Exception) {
//                // Обработка ошибок при открытии PDF-файла или неправильном пароле
//                println("Ошибка при открытии PDF-файла: ${e.message}")
//            }

        } catch (e: InvalidPasswordException) {
            val tempCounter = passwordCount + 1
            val newPassword = finder.findCombinationOfPassword(password.toCharArray(), letters)
            isPasswordCorrect(rarFilePath, String(newPassword), tempCounter)
        } catch (e: Exception) {
            println("something went wrong,try again" + " ${e.message} + ${e.cause} + $e")
        }
    }

}




