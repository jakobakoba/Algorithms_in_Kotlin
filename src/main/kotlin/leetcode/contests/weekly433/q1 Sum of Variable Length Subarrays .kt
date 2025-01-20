package leetcode.contests.weekly433

//Sum of Variable Length Subarrays
fun main(){
    class Solution {
        fun subarraySum(nums: IntArray): Int {
            var ans = 0
            val n = nums.size
            val prefix = IntArray(n+1){0}
            for (i in 0 until n){
                prefix[i + 1] = prefix[i] + nums[i]
            }
            for (i in 0 until n){
                val start = maxOf(0, i - nums[i])
                ans += prefix[i + 1] - prefix[start]

            }
            return ans
        }
    }
    println(Solution().subarraySum(intArrayOf(2,3,1)))
}