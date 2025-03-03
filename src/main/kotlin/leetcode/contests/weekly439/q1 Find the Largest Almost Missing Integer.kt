package leetcode.contests.weekly439

// Find the Largest Almost Missing Integer
fun main(){
    class Solution {
        fun largestInteger(nums: IntArray, k: Int): Int {
            val map = mutableMapOf<Int,Int>()
            val n = nums.size
            for (i in 0 until n - k + 1){
                val set = mutableSetOf<Int>()
                for (j in i until i + k){
                    set.add(nums[j])
                }
                for (num in set){
                    map[num] = map.getOrDefault(num, 0) + 1
                }
            }
            var max = -1
            for ((key, value) in map){
                if (value == 1){
                    max = maxOf(key, max)
                }
            }
            return max
        }
    }
}