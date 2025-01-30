## 347. Top K Frequent Elements

```
class Solution{ 
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int,Int>()
        
        for (num in nums){
            map[num] = map.getOrDefault(num,0) + 1
        }
        
        return map.entries.sortedByDescending{it.value}.take(k).map{it.key}.toIntArray()

    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```