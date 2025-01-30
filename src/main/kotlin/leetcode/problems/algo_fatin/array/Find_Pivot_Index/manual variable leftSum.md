## 724. Find Pivot Index


```
class Solution {
    fun pivotIndex (nums: IntArray): Int {
        val sum = nums.sum()
        var leftSum = 0
        
        for (i in 0 until nums.size){
            val rightSum = sum - leftSum - nums[i]
            if (leftSum == rightSum){
                return i
            }
            leftSum += nums[i]
        }
        return -1
    }
}
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```