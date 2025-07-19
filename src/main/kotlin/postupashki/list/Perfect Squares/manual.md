## 279. Perfect Squares


```
class Solution {
    fun numSquares(n: Int): Int {

        val squares = mutableListOf<Int>()
        var i = 1
        while(i * i <= n){
            squares.add(i * i)
            i++
        }
        
        val dp = IntArray(n + 1){Int.MAX_VALUE}
        dp[0] = 0

        for (i in 1 .. n){
            for (square in squares){
                if (square > i) break
                dp[i] = minOf(dp[i], dp[i - square] + 1)
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

