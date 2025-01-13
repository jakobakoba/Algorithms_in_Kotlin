package leetcode.contests.weekly432
//3418. Maximum Amount of Money Robot Can Earn
fun main(){
    class Solution {
        fun maximumAmount(coins: Array<IntArray>): Int {
            val (n, m) = listOf(coins.size, coins[0].size)

            val dp = Array(n) { Array(m) { IntArray(3) { Int.MIN_VALUE } } }

            fun dfs(i: Int, j: Int, used: Int): Int {
                if (i == n-1 && j == m - 1){
                    return if (used > 0 && coins[i][j] < 0) 0 else coins[i][j]
                }

                if (dp[i][j][used] != Int.MIN_VALUE) return dp[i][j][used]

                var best = Int.MIN_VALUE

                if (i + 1 < n){
                    best = maxOf(best, dfs(i + 1, j, used) + coins[i][j])
                    if (used > 0 && coins[i][j] < 0){
                        best = maxOf(best, dfs(i + 1, j, used - 1))
                    }
                }
                if (j + 1 < m){
                    best = maxOf(best, dfs(i, j + 1, used) + coins[i][j])
                    if (used > 0  && coins[i][j] < 0){
                        best = maxOf(best, dfs(i, j + 1, used - 1))
                    }
                }

                dp[i][j][used] = best
                return best
            }

            return dfs(0,0,2)
        }
    }
}