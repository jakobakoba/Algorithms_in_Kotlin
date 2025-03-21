## 977. Squares of a Sorted Array


```
class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n)

        var left = 0
        var right = n - 1
        var pointer = n - 1
        while(left <= right){
            val leftValue = nums[left] * nums[left]
            val rightValue = nums[right] * nums[right]

            if (leftValue > rightValue){
                ans[pointer] = leftValue
                left++
            } else {
                ans[pointer] = rightValue
                right--
            }
            pointer--
        }
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```