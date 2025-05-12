## 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros



``` 
class Solution {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        var sum1 = 0L
        var zero1 = 0

        for (num in nums1) {
            if (num == 0){
                zero1++
            }
            sum1 += num
        }

        var sum2 = 0L
        var zero2 = 0

        for (num in nums2){
            if (num == 0){
                zero2++
            }
            sum2 += num
        }

        if (zero1 == 0 && zero2 == 0){
            return if (sum1 == sum2) sum1 else -1L
        }

        if (sum1 == sum2){
            if (zero1 == 0 || zero2 == 0) return -1 else maxOf(sum1 + zero1, sum2 + zero2)
        }

        if (zero1 == 0){
            return if (sum1 >= sum2 + zero2) sum1 else -1L
        }
        if (zero2 == 0){
            return if (sum2 >= sum1 + zero1) sum2 else -1L
        }
        return maxOf(zero1 + sum1 , zero2 + sum2)
    }
}

```

**Оценка по времени**: O(n + m)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

