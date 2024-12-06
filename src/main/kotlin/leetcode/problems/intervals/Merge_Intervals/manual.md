## 56. Merge Intervals


```
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val stack = mutableListOf<IntArray>()

        intervals.sortBy{it[0]}
        
        for (interval in intervals){
            if (stack.isEmpty()){
                stack.add(interval)
            } else {
                val last = stack.last()
                if (maxOf(last[0], interval[0]) <= minOf(last[1], interval[1])){
                    stack.removeLast()
                    val left = minOf(last[0], interval[0])
                    val right = maxOf(last[1], interval[1])
                    stack.add(intArrayOf(left, right ))
                } else {
                    stack.add(interval)
                }
            }
        }
        return stack.toTypedArray()
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```