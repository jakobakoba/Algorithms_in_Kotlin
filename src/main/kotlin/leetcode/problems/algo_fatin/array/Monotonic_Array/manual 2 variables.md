## 896. Monotonic Array

```
class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var increasing = true
        var decreasing = true

        if (nums.size == 1) decreasing = false

        for (i in 1 until nums.size){
            if (nums[i - 1] > nums[i]) increasing = false
            if (nums[i - 1] < nums[i]) decreasing = false
        }

        return if (increasing) true else if (decreasing) true else false
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```