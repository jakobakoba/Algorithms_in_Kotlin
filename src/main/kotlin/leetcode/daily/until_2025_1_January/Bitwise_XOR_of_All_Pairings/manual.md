## 2425. Bitwise XOR of All Pairings


```
class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        
        var ans = 0
       
        //odd
        if (nums2.size % 2 == 1) {
            for (num in nums1){
                ans = ans xor num
            }
        }
        //odd
        if(nums1.size % 2 == 1){
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
if even значит противоположная сторона будет even поэтому их можно скипнуть
если odd значит противоположная сторона будет odd и поэтому их надо обработать
```