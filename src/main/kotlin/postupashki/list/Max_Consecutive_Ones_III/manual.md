## 1004. Max Consecutive Ones III


```
class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var limit = 0

        var left = 0

        var ans = 0

        for (right in 0 until nums.size){
            if (nums[right] == 0){
                limit++
                while(limit > k){
                    if (nums[left] == 0){
                        limit -= 1
                    }
                    left++
                }
            }
            ans = maxOf(ans, right - left + 1)
        }
        return ans
    }
}


```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```