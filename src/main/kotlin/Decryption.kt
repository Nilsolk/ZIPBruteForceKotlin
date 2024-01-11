import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.exception.ZipException
import kotlin.random.Random

class Decryption(
    private val communication: Communication,
    private val finder: PasswordFinder
) {
    private val letters: String = when (communication.chooseAlphabet()) {
        true -> "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        //`~!@#$%^&*()_\\-+=[{]}|:;'\",<.>/?"
        false -> {
            println("Type your own characters below, without spaces")
            readln()
        }
    }

    private val passwordLength = communication.getLength()
    fun extractFilesFromEncryptedZip(zipFilePath: String, destinationDir: String) {
        val passwordList = mutableListOf<String>()
        try {
            val zipFile = ZipFile(zipFilePath)
            zipFile.setPassword(finder.find(letters, passwordLength, passwordList).toCharArray())
            zipFile.extractAll(destinationDir)
            println("Файлы успешно извлечены.")
        } catch (e: ZipException) {
            when (e.type) {
                ZipException.Type.WRONG_PASSWORD -> extractFilesFromEncryptedZip(zipFilePath, destinationDir)
                ZipException.Type.FILE_NOT_FOUND -> {

                }
            }
        }
    }
}

class PasswordFinder {
    fun find(alphabet: String, length: Int, list: MutableList<String>): String {
        val stringBuilder = StringBuilder()
        for (i in 0..length) {
            stringBuilder.append(alphabet[Random.nextInt(0, alphabet.length - 1)])
            if (check(stringBuilder.toString(), list)) {
                find(alphabet, length, list)
            }
        }
        return stringBuilder.toString()
    }

    private fun check(newPassword: String, list: MutableList<String>): Boolean = list.equals(newPassword)
}

class Handler {
    fun handleException() {

    }
}
