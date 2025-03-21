## 26. Remove Duplicates from Sorted Array


```
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        var pointer = 0
        for (num in nums){
            if (num !in set){
                nums[pointer] = num
                pointer++
            }
            set.add(num)
        }
        return pointer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```