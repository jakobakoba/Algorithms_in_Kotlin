## 33. Search in Rotated Sorted Array


```
class Solution {
    fun search(nums: IntArray, target: Int): Int {

        fun findOffset(): Int {
            var left = 0
            var right = nums.size - 1

            while (left < right) {
                val mid = (left + right) / 2
                if (nums[mid] > nums[right]) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left
        }

        val offset = findOffset()
        val n = nums.size
        var left = 0
        var right = n - 1


        while (left <= right) {
            val mid = (left + right) / 2
            val i = (mid + offset) % n
            if (nums[i] == target) {
                return i
            } else if (nums[i] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}


```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)
 

**Описание решения**
```
Алгоритм findOffset использует бинарный поиск, чтобы найти эту точку,
 где массив "переламывается" из возрастающего в убывающий, что и является
  началом повторяющегося участка.
```