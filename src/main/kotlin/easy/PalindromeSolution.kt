package easy

class PalindromeSolution {
    fun isPalindrome(x: Int): Boolean {
        val stringX = x.toString()
        val stringRev = x.toString().reversed()
        return stringX == stringRev
    }

    fun isPalindromeWithoutString(x: Int): Boolean {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false
        }

        var num = x
        var revertedNumber = 0
        while (num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10
            num /= 10
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return num == revertedNumber || num == revertedNumber / 10
    }

    fun isPalindromeWithString(x: Int): Boolean {
        when {
            (x < 0 || (x % 10 == 0 && x != 0)) -> return false
            x < 10 -> return true
        }

        val s = x.toString()
        for (i in 0..(s.length / 2)) {
            if (s[i] != s[s.length - 1 - i]) return false
        }
        return true
    }
}

fun main() {
    val palindrome = PalindromeSolution()
    println(palindrome.isPalindrome(121))
}