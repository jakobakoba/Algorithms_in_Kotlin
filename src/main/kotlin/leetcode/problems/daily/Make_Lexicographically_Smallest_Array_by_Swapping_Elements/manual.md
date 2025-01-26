## 2948. Make Lexicographically Smallest Array by Swapping Elements

```
class Solution {
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val groups = mutableListOf<ArrayDeque<Int>>()
        val map = mutableMapOf<Int,Int>()

        val sortedNums = nums.sorted()

        for (num in sortedNums){
            if (groups.isEmpty() || num - groups.last().last() > limit) {
                groups.add(ArrayDeque<Int>())
            }
            groups.last().add(num)
            map[num] = groups.size - 1
        }

        val res = mutableListOf<Int>()
        for (num in nums){
            val j = map[num]!!
            res.add(groups[j].removeFirst())
        }
        return res.toIntArray()
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```