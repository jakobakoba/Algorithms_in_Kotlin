## 674. Longest Continuous Increasing Subsequence


```
class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        if (nums.size  == 1) return 1

        var maxLength = 1
        var length = 1
        for (i in 1 until nums.size){
            if (nums[i - 1] >= nums[i]) {
                length = 0
            }
            length += 1
            maxLength = maxOf(maxLength, length)

        }
        return maxLength
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```