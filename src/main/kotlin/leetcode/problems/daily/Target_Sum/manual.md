## 494. Target Sum


```
class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {

        val dp = mutableMapOf<Pair<Int,Int>, Int>()
         
         fun backtrack(i: Int, cur: Int): Int {
            if (Pair(i, cur) in dp){
                return dp[Pair(i, cur)]!!
            } 
            if (i == nums.size) return if (cur == target) 1 else 0

            dp[Pair(i, cur)] = backtrack(i + 1, cur + nums[i]) + backtrack(i + 1, cur - nums[i])

            return dp[Pair(i, cur)]!!

         }

         return backtrack(0,0)
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```