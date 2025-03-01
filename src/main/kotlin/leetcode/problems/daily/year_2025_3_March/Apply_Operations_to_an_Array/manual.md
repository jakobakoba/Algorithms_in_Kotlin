## 2460. Apply Operations to an Array


```
class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        val n = nums.size
        for (i in 0 until n - 1){
            if (nums[i] == nums[i + 1]){
                nums[i] = nums[i] * 2
                nums[i + 1] = 0
            } else continue
        }
        var pointer = 0

        for (i in 0 until n){
            if (nums[i] != 0){
                val temp = nums[pointer]
                nums[pointer] = nums[i]
                nums[i] = temp
                pointer++
            }
        }
        return nums
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```