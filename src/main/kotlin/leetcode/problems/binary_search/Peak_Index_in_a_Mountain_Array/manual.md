## 852. Peak Index in a Mountain Array


```
class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = 0
        var right = arr.size - 1

        while(left < right){
            val mid = (left + right) / 2

            if (arr[mid] <= arr[mid + 1]){
                left = mid
            } else {
                right = mid - 1
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
если arr[mid] < arr[mid + 1], это означает, что пик находится справа от mid, 
поэтому мы устанавливаем left = mid + 1. Если arr[mid] >= arr[mid + 1], 
пик либо на mid, либо левее, поэтому мы устанавливаем right = mid.

```