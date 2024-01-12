class PasswordFinder {
    fun findCombinationOfPassword(password: CharArray, charset: CharArray): CharArray {
        var i = password.size - 1
        while (i >= 0) {
            val index = charset.indexOf(password[i]) + 1
            if (index < charset.size) {
                password[i] = charset[index]
                return password
            } else {
                password[i] = charset[0]
                i--
            }
        }
        return CharArray(0)
    }

}