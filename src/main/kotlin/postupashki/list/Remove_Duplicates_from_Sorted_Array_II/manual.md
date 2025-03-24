## 80. Remove Duplicates from Sorted Array II


```
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val n = nums.size

        var pointer = 0

        for (i in 0 until n){
            if (i == 0 || i == 1){
                nums[pointer] = nums[i]
                pointer++
            } else if (nums[i] == nums[pointer-1] && nums[i] == nums[pointer-2]){
                    continue
            }
            else {
                nums[pointer] = nums[i]
                pointer++
            }
        }
        return pointer
    }
}

упрощение кода сверху:
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val n = nums.size

        var pointer = 0

        for (num in nums){
            if (pointer < 2 || num != nums[pointer-2]){
                nums[pointer] = num
                pointer++
            }
        }

        return pointer
    }
}



```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```