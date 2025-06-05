## 986. Interval List Intersections



``` 
class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val n = firstList.size
        val m = secondList.size

        var i = 0
        var j = 0

        val ans = mutableListOf<IntArray>()
        while(i < n && j < m){
            val a = firstList[i]
            val b = secondList[j]

            val left = maxOf(a[0], b[0])
            val right = minOf(a[1], b[1])

            if(left <= right){
                ans.add(intArrayOf(left, right))
            }
            if (a[1] < b[1]){
                i++
            } else {
                j++
            }
        }
        return ans.toTypedArray()
    }
}

```

**Оценка по времени**: O(n + m)


**Оценка по памяти**: O(k)


**Описание решения**
```

```

