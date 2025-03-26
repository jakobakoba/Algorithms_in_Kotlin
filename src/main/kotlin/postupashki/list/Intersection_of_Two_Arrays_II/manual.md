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

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```