## 452. Minimum Number of Arrows to Burst Balloons


```
class Solution {
    fun findMinArrowShots(arr: Array<IntArray>): Int {
        arr.sortBy{it[0]}
        var last = arr[0]
        var ans = 1
        for (interval in arr){
            if (maxOf(last[0], interval[0]) <= minOf(last[1], interval[1])){
                last = intArrayOf(maxOf(last[0], interval[0]), minOf(last[1], interval[1]))
                continue
            }
            last = interval
            ans += 1
        }
        return ans       
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```