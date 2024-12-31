## 2466. Count Ways To Build Good Strings


```
class Solution {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val MOD = 1000000007

        val dp = mutableMapOf<Int,Int>()

        fun backtrack(length: Int ): Int {
            if (length > high) return 0

            if (length in dp) return dp[length]!!

            var count = if (length >= low) 1 else 0

            count = (count + backtrack(length + zero) + backtrack(length + one)) % MOD

            dp[length] = count

            return count
        }

        return backtrack(0)
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=QQoIiY4K-M0
```