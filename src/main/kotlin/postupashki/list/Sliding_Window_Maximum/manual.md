## 239. Sliding Window Maximum


```
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque: Deque<Int> = LinkedList()

        val ans = mutableListOf<Int>()

        var left = 0
        var right = 0
        val n = nums.size
        while(right < n){
            while(deque.isNotEmpty() && nums[deque.getLast()] < nums[right]){
                deque.pollLast()
            }
            deque.addLast(right)

            if (left > deque.getFirst()){
                deque.pollFirst()
            }

            if (right + 1 >= k ){
                ans.add(nums[deque.getFirst()])
                left++
            }
            right++
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