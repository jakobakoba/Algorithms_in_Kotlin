## 53. Maximum Subarray



``` 
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var cur = nums[0]
        var max = nums[0]

        for (i in 1 until nums.size){
            cur = maxOf(nums[i], cur + nums[i])
            max = maxOf(max, cur)
        }
        return max
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

