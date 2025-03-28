## 70. Climbing Stairs

intarray
```
class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1

        for (i in 2 .. n){
            dp[i] = dp[i-1] + dp[i-2]
        }
        return dp[n]
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

two variables
```
class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        var first = 1
        var second = 1

        for (i in 2 .. n){
            val next = first + second
            first = second
            second = next
        }
        return second
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```