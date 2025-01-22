package leetcode.contests.weekly433

//Maximum and Minimum Sums of at Most Size K Subsequences

fun main() {
    class Solution {
        fun minMaxSums(nums: IntArray, k: Int): Int {
            val MOD = 1_000_000_007

            val n = nums.size

            val dp = Array(n + 1) { IntArray(k + 1) }

            dp[0][0] = 1
            for (i in 1..n) {
                dp[i][0] = 1
                for (j in 1..k) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD
                }
            }


            nums.sort()
            var total = 0L
            for (i in 0 until n) {
                for (c in 0 until minOf(i + 1, k)) {
                    total += nums[i].toLong() * dp[i][c] % MOD
                }
                total = total % MOD
            }
            nums.reverse()

            for (i in 0 until n) {
                for (c in 0 until minOf(i + 1, k)) {
                    total += nums[i].toLong() * dp[i][c] % MOD
                }
                total = total % MOD
            }
            return total.toInt()
        }
    }

}

//https://www.youtube.com/watch?v=IfmQcGjhktg

/*
dp[i][j] = Number of ways to select j elements from the first i elements
dp[0][0] = 1: There's one way to choose 0 items from 0 items.
dp[i][0] = 1: There's one way to choose 0 items from i items (by choosing nothing).

c: Represents the size of the subset being considered.
 */
