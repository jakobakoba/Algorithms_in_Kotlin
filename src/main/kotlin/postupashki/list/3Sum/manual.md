## 3Sum

```
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<List<Int>>()
        val n = nums.size
        nums.sort()

        for (a in 0 until n){
            var left = a + 1
            var right = n - 1

            while(left < right){
                val sum  = nums[a] + nums[left] + nums[right]
                if (sum == 0){
                    set.add(listOf(nums[a], nums[left], nums[right]))
                    left++
                    right--
                } else if (sum > 0){
                    right--
                } else {
                    left++
                }
            }
        }
        return set.toList()
    }
}

```

**Оценка по времени**: О(n^2)
Time Complexity: O(n²) — Agreed, due to the sorting (O(n log n)) plus the two-pointer loop (O(n²)).

**Оценка по памяти**: О(n)




**Описание решения**
```

```