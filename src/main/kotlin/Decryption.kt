import com.github.junrar.Archive
import com.github.junrar.exception.RarException
import java.io.File

class Decryption(
    private val communication: Communication,
    private val finder: PasswordFinder
) {
    private val passwordLength = communication.getLength()
    private val letters: CharArray = when (communication.chooseAlphabet()) {
        true -> "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
        //`~!@#$%^&*()_\\-+=[{]}|:;'\",<.>/?"
        false -> {
            println("Type your own characters below, without spaces")
            readln().toCharArray()
        }
    }


    fun isPasswordCorrect(
        rarFilePath: String,
        password: String = String(CharArray(passwordLength) { letters[0] })
    ) {
        try {
            println(password)
            val rarFile = File(rarFilePath)
            val archive = Archive(rarFile, password)
            println("Success password is -> $password")
            archive.close()
        } catch (e: RarException) {
            val newPassword = finder.findCombinationOfPassword(password.toCharArray(), letters)
            isPasswordCorrect(rarFilePath, String(newPassword))
        } catch (e: Exception) {
            println("something went wrong,try again" + " ${e.message}")
        }
    }

}




