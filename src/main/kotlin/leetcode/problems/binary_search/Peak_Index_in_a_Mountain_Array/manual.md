## 852. Peak Index in a Mountain Array


```
class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = 0
        var right = arr.size - 1

        while(left < right){
            val mid = (left + right) / 2

            if (arr[mid] < arr[mid + 1]){
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}

```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```