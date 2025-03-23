## 57. Insert Interval


```
class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()
        val n = intervals.size
        for (i in 0 until intervals.size){
            if (newInterval[1] < intervals[i][0]){
                res.add(newInterval)
                return (res + intervals.slice(i until n)).toTypedArray()
            } else if (newInterval[0] > intervals[i][1]){
                res.add(intervals[i])
            } else {
                val left = minOf(newInterval[0], intervals[i][0])
                val right = maxOf(newInterval[1], intervals[i][1])
                newInterval[0] = left
                newInterval[1] = right
            }
        }
        res.add(newInterval)
        return res.toTypedArray()
    }
}




```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```