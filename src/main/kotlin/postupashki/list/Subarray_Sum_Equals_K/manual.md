## 560. Subarray Sum Equals K

```
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val n = nums.size

        var temp = 0

        val map = mutableMapOf(0 to 1)
        var ans = 0
        for (i in 0 until n){
            temp += nums[i]
            if (temp - k in map){
                ans += map[temp - k]!!
            }
            map[temp] = map.getOrDefault(temp, 0) + 1
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```


```