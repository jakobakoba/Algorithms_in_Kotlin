## 57. Insert Interval


```
bad way:
просто кидаю все в одно место и там делаю merge time O(nlogn), space O(n)
class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val combined = mutableListOf<IntArray>()
        combined.addAll(intervals)
        combined.add(newInterval)

        combined.sortBy{it[0]}

        val stack = mutableListOf<IntArray>()
        val ans = mutableListOf<IntArray>()
        for (interval in combined){
            if (stack.isEmpty()){
                stack.add(interval)
            } else {
                val last = stack.last()
                val leftSide = maxOf(last[0], interval[0])
                val rightSide = minOf(last[1], interval[1])

                if (leftSide <= rightSide){
                    stack.removeLast()
                    val leftMerge = minOf(last[0], interval[0])
                    val rightMerge = maxOf(last[1], interval[1])
                    stack.add(intArrayOf(leftMerge, rightMerge))
                } else {
                    ans.add(stack.removeLast())
                    stack.add(interval)
                }
            }
        }
        if (stack.isNotEmpty()){
            ans.add(stack.removeLast())
        }
        return ans.toTypedArray()
    }
}




```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```