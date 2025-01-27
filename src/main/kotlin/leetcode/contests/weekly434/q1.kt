package leetcode.contests.weekly434
//3432. Count Partitions with Even Sum Difference
fun main(){
    class Solution {
        fun countPartitions(nums: IntArray): Int {
            val n = nums.size
            val prefix = IntArray(n + 1)

            for (i in 0 until n){
                prefix[i + 1] = prefix[i] + nums[i]
            }

            var ans = 0
            for (i in 1 until n){
                if ((prefix[i] - (prefix[n] - prefix[i])) % 2 == 0 ){
                    ans++
                }
            }
            return ans
        }
    }

}