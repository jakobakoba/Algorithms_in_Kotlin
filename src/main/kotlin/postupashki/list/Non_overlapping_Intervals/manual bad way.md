## 435. Non-overlapping Intervals


```
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var ans = 0
        val n = intervals.size
        val stack = mutableListOf<IntArray>()
        val sortedIntervals = intervals.sortedBy{it[0]}

        for (i in 0 until n){
            if (stack.isEmpty()){
                stack.add(sortedIntervals[i])
            } else {
                val last = stack.last()
                val left = maxOf(sortedIntervals[i][0], last[0])
                val right = minOf(sortedIntervals[i][1], last[1])

                if (left < right){
                    ans++
                    val l1 = sortedIntervals[i][1]
                    val l2 = last[1]
                    if (l1 < l2){
                        stack.removeLast()
                        stack.add(sortedIntervals[i])
                    } 
                } else {
                    stack.add(sortedIntervals[i])
                }
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```