class MainModel {
    fun start() {
        println("Hello, it`s simple brute force program." +
                "\nYou can use inner characters or type your own alphabet below")
        val communication = Communication()
        val decryption = Decryption(communication, PasswordFinder())
        decryption.extractFilesFromEncryptedZip(
            communication.getPath("Enter path to your secret zip file"),
            communication.getPath("Enter path to your destination directory")
        )
    }
}


