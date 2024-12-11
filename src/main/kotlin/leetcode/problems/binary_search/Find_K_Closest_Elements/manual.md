## 658. Find K Closest Elements


```
class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val n = arr.size
        var left = 0
        var right = n - k

        while(left <  right){
            val mid = (left + right) / 2

            if ((x - arr[mid]) > arr[mid + k] - x){
                left = mid + 1
            } else {
                right = mid
            }
        }
        return arr.toList().subList(left, left + k)
    }
}


```

**Оценка по времени**: О(log n + k)


**Оценка по памяти**: О(k)


**Описание решения**
```

```