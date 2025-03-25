## 3Sum

```
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val ans = mutableListOf<List<Int>>()
        nums.sort()
        for (a in 0 until n){
            if (a > 0 && nums[a] == nums[a-1]){
                continue
            }
            if (nums[a] > 0){
                break
            }

            var left = a + 1
            var right = n - 1

            while(left < right){
                val sum = nums[a] + nums[left] + nums[right]

                if (sum == 0){
                    ans.add(listOf(nums[a], nums[left], nums[right]))
                    left++
                    right--
                    while(left < right && nums[left] == nums[left - 1]){
                        left++
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--
                    }
                } else if (sum > 0){
                    right--
                } else {
                    left++
                }
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(n^2)
Time Complexity: O(n²) — Agreed, due to the sorting (O(n log n)) plus the two-pointer loop (O(n²)).

**Оценка по памяти**: О(n)




**Описание решения**
```

```