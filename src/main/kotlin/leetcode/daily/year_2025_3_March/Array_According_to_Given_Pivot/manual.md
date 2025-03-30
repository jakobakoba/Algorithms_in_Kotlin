## 2161. Partition Array According to Given Pivot


```
class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val pre = mutableListOf<Int>()
        val mid = mutableListOf<Int>()
        val after = mutableListOf<Int>()

        for (num in nums){
            if (num < pivot){
                pre.add(num)
            } else if (num == pivot){
                mid.add(num)
            } else {
                after.add(num)
            }
        }
        val answer = mutableListOf<Int>()
        answer.addAll(pre)
        answer.addAll(mid)
        answer.addAll(after)
        return answer.toIntArray()
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```