package easy

// Roman to Integer

class RomanSolution {
    // Approach 1
    fun romanToInt01(s: String): Int {
        val roman = hashMapOf<String, Int>(
            "M" to 1000,
            "D" to 500,
            "C" to 100,
            "L" to 50,
            "X" to 10,
            "V" to 5,
            "I" to 1
        )

        var sum = 0
        var i = 0
        while (i < s.length) {
            val currentSymbol = s.substring(i, i + 1)
            val currentValue = roman[currentSymbol] ?: 0
            var nextValue = 0
            if (i + 1 < s.length) {
                val nextSymbol = s.substring(i + 1, i + 2)
                nextValue = roman[nextSymbol] ?: 0
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue)
                i += 2
            } else {
                sum += currentValue
                i += 1
            }
        }
        return sum
    }

    // Approach 3: Right-to-Left Pass
    fun romanToInt03(s: String): Int {
        val roman = hashMapOf(
            "M" to 1000,
            "D" to 500,
            "C" to 100,
            "L" to 50,
            "X" to 10,
            "V" to 5,
            "I" to 1
        )

        val lastSymbol = s.substring(s.length - 1)
        var lastValue = roman[lastSymbol] ?: 0
        var total = lastValue

        for (i in s.length - 2 downTo 0) {
            val currentSymbol = s.substring(i, i + 1)
            val currentValue = roman[currentSymbol] ?: 0
            if (currentValue < lastValue) {
                total -= currentValue
            } else {
                total += currentValue
            }
            lastValue = currentValue
        }
        return total
    }


    // Approach 4, Left-to-Right pass
    fun romanToInt(s: String): Int {
        val roman = hashMapOf<Char, Int>(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var sum = 0
        for (i in s.indices) {
            if (i + 1 < s.length) {
                val value1 = roman[s[i]] ?: 0
                val value2 = roman[s[i + 1]] ?: 0
                when (value1 < value2) {
                    true -> sum -= value1
                    false -> sum += value1
                }
            }
            if (i + 1 == s.length) {
                sum += roman[s[i]] ?: 0
            }
        }
        return sum
    }
}
