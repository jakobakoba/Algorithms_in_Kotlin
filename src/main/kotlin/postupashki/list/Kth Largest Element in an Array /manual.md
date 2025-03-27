## 215. Kth Largest Element in an Array

minHeap
```
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()
        for (num in nums) {
            minHeap.add(num)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        return minHeap.peek()
    }
}

```

**Оценка по времени**: О(nlogk)


**Оценка по памяти**: О(k)


**Описание решения**
```

```