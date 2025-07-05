## 88. Merge Sorted Array

```
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var pointer = m + n - 1

        var p1 = m - 1
        var p2 = n - 1

        while(pointer >= 0){
            val left = if (p1 >= 0) nums1[p1] else Int.MIN_VALUE
            val right = if (p2 >= 0) nums2[p2] else Int.MIN_VALUE

            if (left > right){
                nums1[pointer] = nums1[p1]
                p1-- 
            } else {
                nums1[pointer] = nums2[p2]
                p2--
            }
            pointer--
        }
    }
}

solution2:

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var pointer = m + n - 1

        var p1 = m - 1
        var p2 = n - 1

        while(p2 >= 0){
            if (p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[pointer] = nums1[p1]
                p1-- 
            } else {
                nums1[pointer] = nums2[p2]
                p2--
            }
            pointer--
        }
    }
}

solution 3:
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var pointer = m + n - 1
        var l1 = m - 1
        var l2 = n - 1

        while(l1 >= 0 || l2 >= 0 ){
            var num = 0
            val left = if (l1 >= 0) nums1[l1] else Int.MIN_VALUE
            val right = if (l2 >= 0) nums2[l2] else Int.MIN_VALUE
            if (left > right){
                num = left
                l1--
            } else {
                num = right
                l2--
            }
            nums1[pointer] = num
            pointer--
        }
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```