## 1143. Longest Common Subsequence


```
class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val (n, m) = listOf(text1.length, text2.length)
        val dp = Array(n + 1){IntArray(m + 1){0}}

        for (i in n - 1 downTo 0){
            for (j in m - 1 downTo 0){
                if (text1[i] == text2[j]){
                    dp[i][j] = 1 + dp[i + 1][j + 1]
                } else {
                    dp[i][j] = maxOf(dp[i][j + 1], dp[i+1][j])
                }
            }
        }

        return dp[0][0]
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```