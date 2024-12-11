## 2779. Maximum Beauty of an Array After Applying Operation


```
class Solution {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        nums.sort()

        var left = 0
        var ans = 0

        for (right in 0 until nums.size){
            while(nums[right] - nums[left] > 2 * k){
                left++
            }
            ans = maxOf(ans, right - left + 1)
        }
        return ans
    }
}

```

**Оценка по времени**: 
из-за сортировки О(nlogn)


**Оценка по памяти**: 
место использованное для сортировки О(logn)


**Описание решения**
```

```