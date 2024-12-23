package leetcode.contests.weekly429

class `weekly429 q2` {
}

//3397. Maximum Number of Distinct Elements After Operations
fun main(){

    class Solution {
        fun maxDistinctElements(nums: IntArray, k: Int): Int {
            nums.sort()
            var lastUsed = Int.MIN_VALUE
            var count = 0

            for (num in nums) {

                val possibleValue = maxOf(lastUsed + 1, num - k)
                if (possibleValue <= num + k) {
                    lastUsed = possibleValue
                    count++
                }
            }

            return count
        }
    }

}