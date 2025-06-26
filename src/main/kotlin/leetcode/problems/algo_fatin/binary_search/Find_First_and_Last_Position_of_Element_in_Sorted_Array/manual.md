## 34. Find First and Last Position of Element in Sorted Array


```
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        fun findLeft(): Int {
            var left = 0
            var right = nums.size - 1
            while (left <= right) {
                val mid = (left + right) / 2
                if (nums[mid] < target) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
            return if ( left < nums.size && nums[left] == target) left else -1
        }

        fun findRight(): Int {
            var left = 0
            var right = nums.size - 1
            while (left <= right) {
                val mid = (left + right) / 2
                if (nums[mid] <= target) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
            return if (right >= 0 && nums[right] == target) right else -1
        }

        val start = findLeft()
        val end = findRight()
        return intArrayOf(start, end)
    }
}


```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

без функций
```
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        val ans = intArrayOf(-1,-1)

        while(left <= right){
            val mid = (left + right) / 2

            if (nums[mid] < target){
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        if (left < nums.size && nums[left] == target){
            ans[0] = left
        }

        left = 0
        right = nums.size - 1

        while(left <= right){
            val mid = (left + right) / 2
            if (nums[mid] <= target){
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        if (right >= 0 && nums[right] == target){
            ans[1] = right
        }
        return ans

    }
}

```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```