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
            val first = firstList[i]
            val second = secondList[j]

            if (minOf(first[1], second[1]) >= maxOf(first[0], second[0])){
                ans.add(intArrayOf(maxOf(first[0], second[0]), minOf(first[1], second[1])))
            }

            if (first[1] < second[1]){
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

