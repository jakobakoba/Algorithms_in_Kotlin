//Minimum Number of Operations to Make Elements in Array Distinct

fun main() {
    class Solution {

        fun minimumOperations(nums: IntArray): Int {
            val set = mutableSetOf<Int>()

            val n = nums.size

            for (i in n - 1 downTo 0) {
                set.add(nums[i])

                if (set.size < n - i) {
                    return (i + 3) / 3
                }
            }
            return 0
        }
    }
}