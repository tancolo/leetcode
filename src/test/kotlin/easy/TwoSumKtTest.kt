package easy

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class TwoSumKtTest {

    private val solution = TwoSumSolution()

    @Test
    fun twoSumOnePassHashTable02() {
        t(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1))
        t(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2))
        t(intArrayOf(3, 3), 6, intArrayOf(0, 1))
    }

    private fun t(nums: IntArray, target: Int, expected: IntArray) {
        val actual = solution.twoSumOnePassHashTable02(nums, target)

        assertEquals(expected.size, actual.size)
        expected.forEachIndexed { index, i ->
            assertEquals(expected[index], i)
        }
    }
}