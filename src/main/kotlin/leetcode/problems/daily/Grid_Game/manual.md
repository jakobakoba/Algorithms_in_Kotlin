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

for (i in 0 until n){
val top = prefix1[n] - prefix1[i + 1]

for the above code. i + 1 because first robot takes everything i included and second robot starts from
i + 1
but prefix1[n] is the last element in the prefix, because LongArray(n + 1) starts with 0


val bottom = if (i > 0) prefix2[i] else 0
for the above code. this is prefix so i == 0 for prefix will be 0 no matter what
i means sum of range from 0 to i - 1 

```