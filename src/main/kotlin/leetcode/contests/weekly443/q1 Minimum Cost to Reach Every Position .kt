package leetcode.contests.weekly443
//Q1. Minimum Cost to Reach Every Position


fun main(){
    class Solution {
        fun minCosts(cost: IntArray): IntArray {
            val n = cost.size

            val ans = IntArray(n)
            var counter = cost[0]
            ans[0] = counter

            for (i in 1 until n){
                if (cost[i] < counter){
                    counter = cost[i]
                }
                ans[i] = counter
            }
            return ans
        }
    }
}