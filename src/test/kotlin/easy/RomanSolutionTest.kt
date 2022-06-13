package easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RomanSolutionTest {

    private val solution = RomanSolution()
    @Test
    fun romanToInt() {
        t("III", 3)
        t("LVIII", 58)
        t("MCMXCIV", 1994)
        t("CMXCVIII", 998)
    }

    private fun t(s: String, expected: Int) {
        val actual = solution.romanToInt(s)
        assertEquals(expected, actual)
    }

    @Test
    fun romanToInt01() {
        t01("III", 3)
        t01("LVIII", 58)
        t01("MCMXCIV", 1994)
        t01("CMXCVIII", 998)
    }

    private fun t01(s: String, expected: Int) {
        val actual = solution.romanToInt01(s)
        assertEquals(expected, actual)
    }

    @Test
    fun romanToInt03() {
        t03("III", 3)
        t03("LVIII", 58)
        t03("MCMXCIV", 1994)
        t03("CMXCVIII", 998)
        t03("MMCMLXXXIX", 2989)
    }

    private fun t03(s: String, expected: Int) {
        val actual = solution.romanToInt03(s)
        assertEquals(expected, actual)
    }

}