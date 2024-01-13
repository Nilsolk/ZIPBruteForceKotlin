package decryption

import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.exception.ZipException
import user_service.Communication


class ZIPDecryption(
    private val communication: Communication,
    private val finder: PasswordFinder
) : Decryption(communication) {
    override fun decode() {
        var password = String(CharArray(passwordLength) { letters[0] })
        while (true) {
            println(password)
            try {
                val zipFile = ZipFile(path)
                if (zipFile.isEncrypted) {
                    zipFile.setPassword(password.toCharArray())
                }
                zipFile.extractAll("E:\\Java\\")
                println("Пароль верен -> $password")
                println("ZIP-файл открыт успешно.")
                zipFile.close()
                break
            } catch (e: ZipException) {
                val newPassword = finder.findCombinationOfPassword(password.toCharArray(), letters)
                password = String(newPassword)

            } catch (e: Exception) {
                println("something went wrong, try again" + " ${e.message} + ${e.cause} + $e")
                break
            }
        }
    }
}