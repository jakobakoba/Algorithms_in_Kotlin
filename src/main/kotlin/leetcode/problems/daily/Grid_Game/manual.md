## 2017. Grid Game


```
class Solution {
    fun gridGame(grid: Array<IntArray>): Long {
        val n = grid[0].size

        val prefix1 = LongArray(n + 1){0L}
        val prefix2 = LongArray(n + 1){0L}

        var ans = Long.MAX_VALUE

        for (i in 0 until n){
            prefix1[i + 1] = prefix1[i] + grid[0][i]
            prefix2[i + 1] = prefix2[i] + grid[1][i]
        }

        for (i in 0 until n){
            val top = prefix1[n] - prefix1[i + 1]
            val bottom = if(i > 0) prefix2[i]  else 0
            val secondRobot = maxOf(top, bottom)
            ans = minOf(ans, secondRobot)
        }
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=B90kG-ZlptE

```