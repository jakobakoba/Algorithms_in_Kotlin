## Median of Two Sorted Arrays


```
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val (a, b) = if (nums1.size < nums2.size) nums1 to nums2 else nums2 to nums1
        val n = a.size
        val m = b.size



        var left = 0
        var right = n
        
        while(left <= right){
            val i = (left + right ) / 2
            val j = (n + m + 1) / 2 - i

            val aLeft = if (i == 0) Int.MIN_VALUE else a[i - 1]
            val aRight = if (i == n) Int.MAX_VALUE else a[i]
            val bLeft = if (j == 0) Int.MIN_VALUE else b[j - 1]
            val bRight = if (j == m) Int.MAX_VALUE else b[j]

            if (aLeft <= bRight && bLeft <= aRight){
                if ((n + m) % 2 == 0){
                    return (maxOf(aLeft, bLeft) + minOf(bRight, aRight)) / 2.0
                } else {
                    return maxOf(aLeft, bLeft).toDouble()
                }
            } else if (aLeft > bLeft){
                right = i - 1
            } else {
                left = i + 1
            }
        }
        throw IllegalStateException(" ")
    }
}

```

**Оценка по времени**: О(log(min(n,m)))


**Оценка по памяти**: О(1)


**Описание решения**
```

```

