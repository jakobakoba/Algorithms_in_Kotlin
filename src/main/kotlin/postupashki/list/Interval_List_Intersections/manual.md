## 986. Interval List Intersections


```
class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        var p1 = 0
        var p2 = 0

        val ans = mutableListOf<IntArray>()
        val n = firstList.size
        val m = secondList.size
        while(p1 < n && p2 < m){
            val first = firstList[p1]
            val second = secondList[p2]

            val rightSide = minOf(first[1], second[1])
            val leftSide = maxOf(first[0], second[0])

            if (leftSide <= rightSide){
                val leftMerge = maxOf(first[0], second[0])
                val rightMerge = minOf(first[1], second[1])
                ans.add(intArrayOf(leftMerge, rightMerge))
            }

            if (first[1] < second[1]){
                p1++
            } else {
                p2++
            }
        }
        return ans.toTypedArray()
    }
}

```

**Оценка по времени**: О(n + m)


**Оценка по памяти**: О(min(n, m))


**Описание решения**
```

```