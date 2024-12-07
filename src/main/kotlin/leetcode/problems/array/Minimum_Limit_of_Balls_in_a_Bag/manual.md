## 1760. Minimum Limit of Balls in a Bag


```

class Solution {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        val maximus = nums.sumOf{it}
        
        var ans = maximus
        var left = 1
        var right = maximus

        while(left <= right) {
            val mid = (left + right) / 2
            var operations = 0
            
            for (num in nums){
                operations += (num - 1) / mid
                if (operations > maxOperations) break
            }
            if (operations <= maxOperations){
                ans = minOf(ans, mid)
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return ans
    }
}


```

**Оценка по времени**: О(nlogm)


**Оценка по памяти**: О(1)


**Описание решения**
```
neetcode:
ops += ceil(n / max_balls) - 1

example:
ceil (10/3) - 1 = 3.33 - 1 = 4 - 1 = 3

(10 - 1) / 3 = 9 / 3 = 3 

```