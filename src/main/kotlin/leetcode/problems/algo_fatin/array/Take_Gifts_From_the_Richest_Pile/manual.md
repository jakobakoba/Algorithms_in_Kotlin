## 2558. Take Gifts From the Richest Pile


```

class Solution {
    fun findNum(x: Long): Long {
        var left = 1L
        var right = x
    
        while (left <= right) {
            val mid = (left + right) / 2
            if (mid <= x / mid) { 
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return right
}

    fun pickGifts(gifts: IntArray, k: Int): Long {
        val giftsLong = gifts.map{it.toLong()}.toMutableList()
        val pq = PriorityQueue<Pair<Long, Int>>(compareByDescending{it.first})
        giftsLong.forEachIndexed{ index, value ->
            pq.add(Pair(value,index))
        }
        repeat(k){

            val (value, index) = pq.poll()
            
            val newValue = findNum(value)
            giftsLong[index] = newValue

            pq.add(Pair(newValue, index))
        }
        return giftsLong.sum()
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```