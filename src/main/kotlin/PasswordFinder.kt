class PasswordFinder {
//    fun find(alphabet: String, length: Int, list: MutableList<String>): String {
//        val stringBuilder = StringBuilder()
//        for (i in 0..<length) {
//            stringBuilder.append(alphabet[Random.nextInt(0, alphabet.length - 1)])
//        }
//        if (check(stringBuilder.toString(), list)) {
//            find(alphabet, length, list)
//        }
//        return stringBuilder.toString()
//    }

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


    private fun check(newPassword: String, list: MutableList<String>): Boolean = list.equals(newPassword)
}