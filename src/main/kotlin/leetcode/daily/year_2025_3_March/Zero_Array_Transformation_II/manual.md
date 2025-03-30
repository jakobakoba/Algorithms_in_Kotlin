## 3356. Zero Array Transformation II


```
class Solution {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        val n = nums.size
        val reduction = IntArray(n){0}

        fun checkIfPossible(left: Int, right: Int): Boolean {
            if (right > left){
                for (i in left until right){
                    val(start, end, value) = queries[i]
                    reduction[start] += value
                    if (end + 1 < n){
                        reduction[end + 1] -= value
                    }
                }
            } else {
                for (i in right until left){
                    val (start, end, value) = queries[i]
                    reduction[start] -= value
                    if (end + 1 < n){
                        reduction[end + 1] += value
                    }
                }
            }
            val total = LongArray(n)
            total[0] = reduction[0].toLong()
            for (i in 1 until n){
                total[i] = total[i-1] + reduction[i]
            }

            for (i in 0 until n){
                if (nums[i] > total[i]){
                    return false
                }
            }
            return true
        }

        var from = 0
        var left = 0
        var right = queries.size
        var answer = -1

        while(left <= right){
            val mid = (left + right) / 2
            if (checkIfPossible(from, mid)){
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
            from = mid
        }
        return answer

    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```