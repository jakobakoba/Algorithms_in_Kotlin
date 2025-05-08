## 2962. Count Subarrays Where Max Element Appears at Least K Times


```

class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var max = 0
        for (num in nums){
            max = maxOf(max, num)
        }
        
        var counter = 0
        var ans = 0L
        var left = 0
        for (right in 0 until nums.size){
            if (nums[right] == max){
                counter++
            }
            
            if (counter >= k){
                ans += (nums.size - right).toLong()
            }
            
            while(counter >= k){
                if (nums[left] == max){
                    counter--
                }
                left++
                if (counter >= k){
                    ans += (nums.size - right).toLong()
                }
            }
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

