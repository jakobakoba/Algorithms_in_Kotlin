## 153. Find Minimum in Rotated Sorted Array


```
<= способ:
class Solution {
    fun findMin(nums: IntArray): Int {
        val n = nums.size
        var left = 0
        var right = n - 1

        var min = Int.MAX_VALUE
        while (left <= right) {
            val mid = (left + right) / 2
            min = minOf(min, nums[mid]) 

            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }   
        return min
    }
}

< способ
class Solution {
    fun findMin(nums: IntArray): Int {
        val n = nums.size
        var left = 0
        var right = n - 1

        while(left < right){
            val mid = (left + right) / 2
            if (nums[mid] > nums[right]){
                left = mid + 1
            } else {
                right = mid
            } 
        }
        return nums[right]
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```