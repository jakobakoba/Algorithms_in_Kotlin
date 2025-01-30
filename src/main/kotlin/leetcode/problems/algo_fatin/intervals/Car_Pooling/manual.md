## 1094. Car Pooling


```

class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int) : Boolean {
        trips.sortBy{it[1]}
        val passengers = mutableListOf<Pair<Int,Int>>()
        
        for ((people, start, end) in trips){
            passengers.add(Pair(start, people))
            passengers.add(Pair(end, -people))
        }
        
        passengers.sortBy{it.first}
        
        var max = 0
        var temp = 0
        for (i in passengers){
            temp += i.second
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