## 485. Max Consecutive Ones


```
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0

        var temp = 0
        val n = nums.size

        for (num in nums){
            if (num == 1){
                temp++
            } else {
                temp = 0
            }
            max = maxOf(max, temp)
        }
        return max
        
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```