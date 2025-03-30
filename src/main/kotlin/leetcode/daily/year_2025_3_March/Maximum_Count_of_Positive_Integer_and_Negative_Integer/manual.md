## 2529. Maximum Count of Positive Integer and Negative Integer


```
class Solution {
    fun maximumCount(nums: IntArray): Int {
        var min = 0
        var max = 0

        for (num in nums){
            if (num < 0){
                min++
            } else if (num > 0){
                max++
            }
        }
        return maxOf(min, max)
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```