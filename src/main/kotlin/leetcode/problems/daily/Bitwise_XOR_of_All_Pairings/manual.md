## 2425. Bitwise XOR of All Pairings


```
class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        
        var ans = 0

        if (nums2.size % 2 != 0) {
            for (num in nums1){
                ans = ans xor num
            }
        }
        if(nums1.size % 2 != 0){
            for (num in nums2){
                ans = ans xor num
            }
        }

        return ans
    }
}
```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```