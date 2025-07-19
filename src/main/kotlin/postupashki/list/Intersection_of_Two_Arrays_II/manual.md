## 350. Intersection of Two Arrays II


```
class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int,Int>()

        for (num in nums1){
            map[num] = map.getOrDefault(num, 0) + 1
        }
        val ans = mutableListOf<Int>()
        for (num in nums2){
            if (num in map){
                ans.add(num)
                map[num] = map.getOrDefault(num, 0) - 1
                if (map[num]!! == 0){
                    map.remove(num)
                }
            }
        }
        return ans.toIntArray()
    }
}

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map1 = mutableMapOf<Int,Int>()
        for (num in nums1){
            map1[num] = map1.getOrDefault(num, 0) + 1
        }

        val map2 = mutableMapOf<Int,Int>()
        for (num in nums2){
            map2[num] = map2.getOrDefault(num, 0) + 1
        }
        val ans = mutableListOf<Int>()
        for ((key, value) in map1){
            if (key in map2){
                val first = map1[key]!!
                val second = map2[key]!!
                repeat(minOf(first, second)){
                    ans.add(key)
                }
            }
        }
        return ans.toIntArray()
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```