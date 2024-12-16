## 69. Sqrt(x)


```
class Solution {
    fun mySqrt(x: Int): Int {
        var left = 1
        var right = x

        while (left <= right) {
            val mid = (left + right) / 2

            if (mid <= x / mid) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return right
    }
}


```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(1)


**Описание решения**
```
16
mid 8 = 64 > 16 = right = mid - 1 = 7
mid 4 = 16 <= 16 = left = mid + 1 = 5
mid 6 = 36 > 16 = right = mid - 1 = 5
mid 5 = 25 > 16 = right = mid - 1 = 4
mid 4 = 16 <= 16 = left = mid + 1 = 5 (cycle quits left is 5 and right is 4)
return right

```