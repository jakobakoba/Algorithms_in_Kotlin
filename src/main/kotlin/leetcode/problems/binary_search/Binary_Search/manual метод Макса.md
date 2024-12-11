## 704. Binary Search


```
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size 

        while(right - left > 1){
            val mid = (left + right ) /2

            if (nums[mid] <= target){
                left = mid
            } else {
                right = mid
            }
        }
        return if (nums[left] == target) left else -1
    }
}

```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```