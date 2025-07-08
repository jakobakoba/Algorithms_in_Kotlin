## 153. Find Minimum in Rotated Sorted Array


```
class Solution {
    fun findMin(nums: IntArray): Int {
        val n = nums.size
        var left = 0
        var right = n - 1 

        var min = Int.MAX_VALUE

        while(left <= right){
            val mid = (left + right) / 2
            min = minOf(min, nums[mid])
            if (nums[mid] > nums[right]){
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return min
    }
}
```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```