package easy
class TwoSumSolution {
    fun twoSumOnePassHashTable02(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, item ->
            val found = map[target - item]
            found?.let {
                return intArrayOf(found, index)
            }
            map[item] = index
        }
        throw IllegalArgumentException("No solution")
    }

    fun twoSumOnePassHashTable(nums: IntArray, target: Int): IntArray {
        // 03 One-pass HashTable
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.contains(complement)) {
                println("[${map[complement]}, $i]")
                return intArrayOf(map[complement]!!, i)
            }

            map[nums[i]] = i
        }

        throw java.lang.IllegalArgumentException("No Solution!!!")
    }


    fun twoSumTwoPassHashTable(nums: IntArray, target: Int): IntArray {
        // 02 HashTable
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            map[nums[i]] = i
        }

        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.contains(complement) && map[complement] != i) {
                println("[$i, ${map[complement]}]")
                return intArrayOf(i, map[complement]!!)
            }
        }
        throw java.lang.IllegalArgumentException("No Solution!!!")
    }

    fun twoSumSimple(nums: IntArray, target: Int): IntArray {
// 01 simple clean approach, work well
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    println("[$i, $j]")
                    return intArrayOf(i, j)
                }
            }
        }

        throw IllegalArgumentException("No solution!!!")
    }

    fun twoSum02(nums: IntArray, target: Int): IntArray {
        // Approach 3
        val result = IntArray(2)
        val numMutableList = nums.toMutableList()
        var isFound = false
        println(numMutableList)

        run breaking1@{
            nums.map { number ->
                result[0] = number
                println("number = $number")
                val temps = numMutableList.subList(nums.indexOf(number) + 1, nums.size)
                println("temp list: $temps")
                run breaking2@{
                    temps.map {
                        if (number + it == target) {
                            result[1] = it
                            isFound = true
                            return@breaking2
                        }
                    }
                }

                if (isFound) return@breaking1
            }
        }
        println("${result[0]}, ${result[1]}")

        val index = when (nums.indexOf(result[0]) == nums.indexOf(result[1])) {
            true -> intArrayOf(nums.indexOf(result[0]), nums.lastIndexOf(result[1]))
            else -> intArrayOf(nums.indexOf(result[0]), nums.indexOf(result[1]))
        }
        println(index.toList())
        return index
    }

    fun twoSum01(nums: IntArray, target: Int): IntArray {
        println(nums.toList())
        println(target)
        val result: IntArray = IntArray(2)

        val numMutableList = nums.toMutableList()
        var isFound = false
        var indexNums = 0
        var indexTemps = 1
        println(numMutableList)

        run breaking1@{
            nums.map {
                result[0] = it
                println("result[0] = ${result[0]}")
                val indexOfFirst = nums.indexOf(it)
                println("indexOfFirst = $indexOfFirst, indexNums = $indexNums")
                val temps = numMutableList.subList(nums.indexOf(it) + 1, nums.size)
                println("new list: $temps")

                run breaking2@{
                    temps.map {
                        println("ititit = $it,  result[0] = ${result[0]}")
                        if (result[0] + it == target) {
                            result[1] = it
                            isFound = true
                            return@breaking2
                        }
                        indexTemps += 1
                    }
                }

                if (isFound) return@breaking1
                indexNums += 1
            }
        }
        println("indexNums = $indexNums, indexTemps = $indexTemps")

        println(result.toList())
        return result
    }
}

fun main() {
//    val numbs = listOf<Int>(2,7,11,15).toIntArray()
//    val numbs = listOf<Int>(3,3).toIntArray()
    val numbs = listOf<Int>(3, 2, 4).toIntArray()

//    val target = 9
    val target = 6

    TwoSumSolution().twoSumOnePassHashTable02(numbs, target)
}