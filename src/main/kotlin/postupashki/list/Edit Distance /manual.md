## 72. Edit Distance


```
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1){IntArray(word2.length + 1){Int.MAX_VALUE}}

        for (i in 0 until word1.length + 1){
            dp[i][word2.length] = word1.length - i
        }
        for (i in 0 until word2.length + 1){
            dp[word1.length][i] = word2.length - i
        }

        for (i in word1.length - 1 downTo 0){
            for (j in word2.length - 1 downTo 0){
                if (word1[i] == word2[j]){
                    dp[i][j] = dp[i+1][j+1]
                } else {
                    dp[i][j] = 1 + minOf(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])
                }
            }
        }
        return dp[0][0]


    }
}

```

**Оценка по времени**: О(mn)


**Оценка по памяти**: О(mn)


**Описание решения**
```

```

