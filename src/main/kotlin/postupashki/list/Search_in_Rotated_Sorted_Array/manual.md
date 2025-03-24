## 33. Search in Rotated Sorted Array


```
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size

        var left = 0
        var right = n - 1

        var ans = -1

        while(left <= right){
            val mid = (left + right) / 2

            if (nums[mid] == target){
                ans = mid
                break
            }

            if (nums[left] <= nums[mid]){
                if (target >= nums[left] && target < nums[mid]){
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)
 

**Описание решения**
```

```