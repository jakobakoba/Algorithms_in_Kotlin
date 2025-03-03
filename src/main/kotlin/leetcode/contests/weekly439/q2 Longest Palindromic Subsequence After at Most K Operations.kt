package leetcode.contests.weekly439

// Longest Palindromic Subsequence After at Most K Operations
fun main(){
    class Solution {
        fun cost(c1: Char, c2: Char): Int {
            val dist = Math.abs((c1 -  'a') - (c2 - 'a'))
            return minOf(dist, 26 - dist)
        }

        fun longestPalindromicSubsequence(s: String, k: Int): Int {
            val n = s.length

            val dp = Array(n){Array(n){IntArray(k + 1){0}}}

            for (i in 0 until n){
                for (j in 0 until k + 1){
                    dp[i][i][j] = 1
                }
            }

            for (i in n - 1 downTo 0){
                for (j in i + 1 until n){
                    for (z in 0 until k + 1){
                        if (s[i] == s[j]){
                            dp[i][j][z] = dp[i+1][j-1][z] + 2
                        } else {
                            dp[i][j][z] = maxOf(dp[i+1][j][z], dp[i][j-1][z])
                            val d = cost(s[i], s[j])
                            if (d <= z){
                                dp[i][j][z] = maxOf(dp[i][j][z], dp[i + 1][j-1][z - d] + 2)
                            }
                        }
                    }
                }
            }
            return dp[0][n-1][k]
        }
    }
}

//https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/solutions/6486278/python-more-intuitive-bottom-up-implementation-than-other-solution-top-down-solution/