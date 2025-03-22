## 209. Minimum Size Subarray Sum


```
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var min = Int.MAX_VALUE
        val n = nums.size
        var left = 0
        var temp = 0


        for (right in 0 until n){
            temp += nums[right]
            while(temp >= target ){
                min = minOf(min, right - left + 1)
                temp -= nums[left]
                left++
            } 
        }
        return if (min == Int.MAX_VALUE) 0 else min


    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```