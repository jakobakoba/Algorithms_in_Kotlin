## 560. Subarray Sum Equals K

```
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()
        
        var cur = 0
        
        var answer = 0
        
        map[0] = 1
        
        for (i in 0 until nums.size){
            cur += nums[i]
            
            val needed = cur - k
            
            if (map.contains(needed)){
                answer += map[needed]!!
            }
            
            map[cur] = map.getOrDefault(cur, 0) + 1
        }
        return answer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```