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

```