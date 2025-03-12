## 228. Summary Ranges


```
class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val n = nums.size
        var left = 0 
        val ans = mutableListOf<String>()
        for (right in 0 until n){
            if (right == n - 1 || nums[right] + 1 != nums[right + 1]){
                if (right == left){
                    ans.add("${nums[left]}")
                } else {
                    ans.add("${nums[left]}->${nums[right]}")
                }
                left = right + 1
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```