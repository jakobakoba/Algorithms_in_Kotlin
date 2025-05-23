## 16. 3Sum Closest



``` 
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var closest = -1
        var delta = Int.MAX_VALUE
        val n = nums.size
        nums.sort()
        for (a in 0 until n){
            var left = a + 1
            var right = n - 1

            
            while(left < right){
                val sum = nums[a] + nums[left] + nums[right]
                val d = Math.abs(target - sum)
                if (d < delta){
                    delta = d
                    closest = sum
                }
                if (sum == target){
                    return sum
                } else if (sum > target){
                    right--
                } else {
                    left++
                }
            }
            
        }
        return closest
    }
}

```

**Оценка по времени**: O(n2)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

