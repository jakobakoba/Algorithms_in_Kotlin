## 509. Fibonacci Number

map
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

array
```
class Solution {

    fun calculate(num: Int, dp: IntArray): Int {
        if (dp[num] == -1){
            dp[num] = calculate(num - 1, dp) + calculate(num - 2, dp)
        }
        return dp[num]
    }
    
    fun fib(n: Int): Int {
        if (n == 0) return 0
        val dp = IntArray(n + 1){-1}

        dp[0] = 0
        dp[1] = 1

        return calculate(n, dp)    
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

динамическое программирование for цикл
```
class Solution {
    fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        val dp = IntArray(n + 1)
        dp[0] = 0
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