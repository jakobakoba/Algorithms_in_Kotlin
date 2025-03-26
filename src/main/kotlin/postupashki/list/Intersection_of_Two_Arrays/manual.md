## 349. Intersection of Two Arrays

pointers:
```
class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()

        val ans = mutableListOf<Int>()

        var left = 0
        var right= 0 

        while(left < nums1.size && right < nums2.size){
            if (nums1[left] == nums2[right] && (ans.isEmpty() || ans.last() != nums1[left])){
                ans.add(nums1[left])
            }
            if (nums1[left] > nums2[right]){
                right++
            } else {
                left++
            }
        }
        return ans.toIntArray()
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

set this is better because runtime O(n) without sorting:
```
class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val ans = mutableListOf<Int>()
        val set = mutableSetOf<Int>()

        for (num in nums1){
            set.add(num)
        }

        for (num in nums2){
            if (num in set){
                ans.add(num)
                set.remove(num)
            }
        }
        return ans.toIntArray()
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```
