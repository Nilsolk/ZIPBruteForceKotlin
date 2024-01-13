package decryption

import com.github.junrar.Archive
import com.github.junrar.exception.RarException
import user_service.Communication
import java.io.File

/**
 * Works, but only 120 times, then going something strange
 */
class RARDecryption(
    private val communication: Communication,
    private val finder: PasswordFinder
) : Decryption(communication) {
    override fun decode() {
        var password = String(CharArray(passwordLength) { letters[0] })
        while (true) {
            println(password)
            try {
                val rarFile = File(path)
                val archive = Archive(rarFile, password)
                println("Success password is -> $password")
                println("RAR-файл открыт успешно")
                archive.close()
                break
            } catch (e: RarException) {
                val newPassword = finder.findCombinationOfPassword(password.toCharArray(), letters)
                password = String(newPassword)
            } catch (e: Exception) {
                println("something went wrong,try again" + " ${e.message}")
                break
            }
        }
    }

}


