## 347. Top K Frequent Elements

```
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = mutableMapOf<Int,Int>()

        for (num in nums){
            map[num] = map.getOrDefault(num, 0) + 1
        }


        val sortedMap = map.entries.sortedByDescending{it.value}
        
        var counter = k
        val ans = mutableListOf<Int>()
        for ((key, _) in sortedMap){
            ans.add(key)
            counter--
            if(counter == 0) break
        }
        return ans.toIntArray()

    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```