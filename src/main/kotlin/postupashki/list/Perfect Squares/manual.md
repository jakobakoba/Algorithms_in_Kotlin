## 279. Perfect Squares


```
class Solution {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1){n}

        dp[0] = 0

        for (target in 1 .. n){
            for (s in 1 .. target){
                val square = s * s
                if (target - square < 0) break
                dp[target] = minOf(dp[target], 1 + dp[target- square])
            }
        }
        return dp[n]
    }
}

```

**Оценка по времени**: О(n√n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

