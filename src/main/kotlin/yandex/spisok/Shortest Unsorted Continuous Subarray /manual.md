## 581. Shortest Unsorted Continuous Subarray



nlogn (sorted)
``` 
class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val sorted = nums.sorted()
        var counter = 0
        var left = -1
        var right = -1
        for (i in 0 until nums.size){
            if(nums[i] != sorted[i]){
                if(left == -1){
                    left = i
                }
                right = i
            }
        }
        return if (left == -1) 0 else right - left + 1
    }
}

```

**Оценка по времени**: nlogn


**Оценка по памяти**: n


**Описание решения**
```

```

O(n)
``` 
class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val n = nums.size
        
        var max = nums[0]
        var min = nums[n-1]

        var right = -1
        for (i in 0 until n){
            max = maxOf(max, nums[i])
            if (nums[i] < max){
                right = i
            }
        }

        var left = -1
        for (i in n - 1 downTo 0){
            min = minOf(min, nums[i])
            if (nums[i] > min){
                left = i
            }
        }

        return if (left == -1) 0 else right - left + 1


    }
}

```

**Оценка по времени**: O(n)

**Оценка по памяти**: O(1)


**Описание решения**
```

```
