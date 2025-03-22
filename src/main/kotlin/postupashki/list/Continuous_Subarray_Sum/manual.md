## 523. Continuous Subarray Sum


```
class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf(0 to -1)

        var temp = 0

        for (i in 0 until nums.size){
            temp += nums[i]
            val remainder = temp % k

            if (remainder !in map){
                map[remainder] = i
            } else {
                if (i - map[remainder]!! >= 2){
                    return true
                }
            }
        }
        return false
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=OKcrLfR-8mE

```