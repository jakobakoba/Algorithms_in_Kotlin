## 509. Fibonacci Number


```
class Solution {
    fun fib(n: Int): Int {
        val dp = mutableMapOf<Int, Int>()

        fun dfs(i: Int): Int {
            if (i == 0) return 0
            if (i == 1) return 1
            if (i in dp) return dp[i]!!

            val ans = dfs(i - 1) + dfs(i - 2)
            dp[i] = ans
            return ans
        }
        return dfs(n)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```