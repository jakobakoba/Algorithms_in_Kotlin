## 2570. Merge Two 2D Arrays by Summing Values


```
class Solution {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val map = mutableMapOf<Int,Int>()

        for ((a,b) in nums1){
            map[a] = b
        }
        for ((a,b) in nums2){
            map[a] = map.getOrDefault(a, 0) + b
        }
        val ans = mutableListOf<IntArray>()
        for ((key, value) in map.toSortedMap()){
            ans.add(intArrayOf(key,value))
        }
        return ans.toTypedArray()
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```