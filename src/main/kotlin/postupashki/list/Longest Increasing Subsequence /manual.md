## 300. Longest Increasing Subsequence


```
 class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n){1}

        for (i in n - 1 downTo 0){
            for (j in i + 1 until n){
                if (nums[i] < nums[j]){
                    dp[i] = maxOf(dp[i], 1 + dp[j])
                }
            }
        }
        return dp.max()
    }
}

```

**Оценка по времени**: О(n^2)


**Оценка по памяти**: О(n)


**Описание решения**
```

```