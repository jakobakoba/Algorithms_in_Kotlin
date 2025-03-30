## 2401. Longest Nice Subarray


```
class Solution {
    fun longestNiceSubarray(nums: IntArray): Int {
        val n = nums.size

        var max = 0
        var left = 0
        var bit = 0

        for (right in 0 until n){
            while((bit and nums[right]) != 0){
                bit = bit xor nums[left]
                left++
            }

            max = maxOf(max, right - left + 1)
            bit = bit or nums[right]
        }
        return max
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```