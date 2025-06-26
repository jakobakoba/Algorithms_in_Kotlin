## 2294. Partition Array Such That Maximum Difference Is K



``` 
class Solution {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()

        val n = nums.size

        var count = 1

        var start = nums[0]

        for (i in 1 until n){
            if (nums[i] - start > k){
                count++
                start = nums[i]
            }
        }
        return count 
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

