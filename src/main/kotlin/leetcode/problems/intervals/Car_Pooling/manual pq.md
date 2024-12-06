## 1094. Car Pooling


```

import java.util.*
class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int) : Boolean {
        val pq = PriorityQueue(compareBy<Pair<Int,Int>>{it.first}.thenBy{it.second})
        trips.sortBy{it[1]}
        
        for ((people, start, end) in trips){
            pq.add(Pair(start, people))
            pq.add(Pair(end, -people))
        }
        
        var max = 0
        var temp = 0
        while(pq.isNotEmpty()){
            val elem = pq.poll()
            temp += elem.second
            max = maxOf(max, temp)
        }
        return max <= capacity
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```