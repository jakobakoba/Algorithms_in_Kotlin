## 347. Top K Frequent Elements

```
class Solution{ 
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        
        val map = mutableMapOf<Int,Int>()
        
        for (num in nums){
            map[num] = map.getOrDefault(num,0) + 1
        }
        
        
        val ans = Array(nums.size + 1){mutableListOf<Int>()}
        for ((key,value) in map){
            ans[value].add(key)
        }
        val results = mutableListOf<Int>()

        for (i in ans.size - 1 downTo 0){
            if (ans[i].isNotEmpty()){
                results.addAll(ans[i])
            }
            if (results.size >= k) break
        }
        return results.toIntArray()
    }
}
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```