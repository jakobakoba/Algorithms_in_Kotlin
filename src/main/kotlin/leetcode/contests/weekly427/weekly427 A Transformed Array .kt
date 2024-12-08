package leetcode.contests.weekly427

fun main(){

    class Solution {
        fun constructTransformedArray(nums: IntArray): IntArray {
            val n = nums.size

            val ans = IntArray(n)

            for (i in 0 until n){
                if (nums[i] > 0){
                    val index = (i + nums[i] ) % n
                    ans[i] = nums[index]
                } else if (nums[i] < 0){
                    val index = ((i + nums[i]) % n + n) % n
                    ans[i] = nums[index]
                } else{
                    ans[i] = nums[i]
                }
            }
            return ans

        }
    }
}






















