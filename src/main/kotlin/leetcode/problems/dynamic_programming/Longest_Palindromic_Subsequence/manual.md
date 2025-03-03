## 516. Longest Palindromic Subsequence


```
class Solution {
    fun longestCommonSubsequence(s1: String, s2: String): Int {
        val (n, m) = listOf(s1.length, s2.length)

        val dp = Array(n + 1){IntArray(m + 1){0}}

        for (i in 0 until n){
            for (j in 0 until m){
                if (s1[i] == s2[j]){
                    dp[i + 1][j + 1] = 1 + dp[i][j]
                } else {
                    dp[i + 1][j + 1] = maxOf(dp[i][j + 1], dp[i + 1][j])
                }
            }
        }
        return dp[n][m]
    }

    fun longestPalindromeSubseq(s: String): Int {
        return longestCommonSubsequence(s, s.reversed())
    }


}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```