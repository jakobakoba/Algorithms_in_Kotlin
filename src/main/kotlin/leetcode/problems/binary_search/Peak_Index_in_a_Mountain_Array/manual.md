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
if (arr[mid] < arr[mid + 1]) then peak 100% on the right side
when arr[mid] >= arr[mid + 1] mid could be the peak 
in the end left and right will be at the same position

In the peak finding algorithm, left and right have specific jobs:
left moves right when the peak is still ahead.
right moves left when we've gone past or found the peak.

```