## 1493. Longest Subarray of 1's After Deleting One Element


```
class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val n = nums.size
        var left = 0
        var zero = 0
        var ans = 0
        for (right in 0 until n){
            if (nums[right] == 0){
                zero++
            }
            while(zero > 1){
                if (nums[left] == 0){
                    zero--
                }
                left++
            }
            ans = maxOf(ans, right - left)
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```