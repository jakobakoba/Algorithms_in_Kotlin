## 704. Binary Search


```
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while(left <= right){
            val mid = (left + right) / 2

            if (nums[mid] == target){
                return mid
            } else if (nums[mid] < target ){
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}
```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```