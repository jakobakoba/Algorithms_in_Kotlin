## 1004. Max Consecutive Ones III


```
class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        val n = nums.size

        var zeros = 0

        var left = 0

        var max = 0

        for (right in 0 until n){
            if (nums[right] == 0){
                zeros++
            }
            while(zeros > k){
                if (nums[left] == 0){
                    zeros--
                }
                left++
            }

            max = maxOf(max, right - left + 1)
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