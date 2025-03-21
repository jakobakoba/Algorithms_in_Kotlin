## 26. Remove Duplicates from Sorted Array


```
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var pointer = 1

        for (i in 1 until nums.size){
            if (nums[i] != nums[i-1]){
                nums[pointer] = nums[i]
                pointer++
            }
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