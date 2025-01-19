package leetcode.contests.weekly433

//Sum of Variable Length Subarrays
fun main(){
    class Solution {
        fun subarraySum(nums: IntArray): Int {
            var ans = 0
            for (i in 0 until nums.size) {
                val start = maxOf(0, i - nums[i])
                for (j in start until i) {
                    ans += nums[j]
                }
                if (start <= i){
                    ans += nums[i]
                }
            }
            return ans
        }
    }
    println(Solution().subarraySum(intArrayOf(2,3,1)))
}