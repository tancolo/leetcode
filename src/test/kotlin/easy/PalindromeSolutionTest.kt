package easy

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class PalindromeSolutionTest {

    private val solution = PalindromeSolution()
    @Test
    fun isPalindrome() {
        t(121, true)
        t(-121, false)
        t(10, false)
    }

    private fun t(num: Int, expected: Boolean) {
        val actual = solution.isPalindrome(num)
        assertEquals(expected, actual)
    }

    @Test
    fun isPalindromeWithoutString() {
        t1(0, true)
        t1(121, true)
        t1(-121, false)
        t1(10, false)
        t1(1221, true)
        t1(12321, true)
    }

    private fun t1(num: Int, expected: Boolean) {
        val actual = solution.isPalindromeWithoutString(num)
        assertEquals(expected, actual)
    }

    @Test
    fun isPalindromeWithString() {
        t2(0, true)
        t2(121, true)
        t2(-121, false)
        t2(10, false)
        t2(1221, true)
        t2(12321, true)
    }

    private fun t2(num: Int, expected: Boolean) {
        val actual = solution.isPalindromeWithString(num)
        assertEquals(expected, actual)
    }
}