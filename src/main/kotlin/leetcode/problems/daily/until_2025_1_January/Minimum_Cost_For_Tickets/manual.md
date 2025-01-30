## 983. Minimum Cost For Tickets


```
class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val dp = mutableMapOf<Int,Int>()
        val n = days.size

        fun dfs(i: Int): Int{
            if (i == n){
                return 0
            }

            if (i in dp){
                return dp[i]!!
            }

            var res = Int.MAX_VALUE
            for ((cost, duration) in costs.zip(listOf(1,7,30))){
                var j = i
                while(j < n && days[j] < days[i] + duration){
                    j += 1
                }
                res = minOf(res, cost + dfs(j))
            }
            dp[i] = res
            return res
        }
        return dfs(0)
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=4Kww-zIkWWY

```