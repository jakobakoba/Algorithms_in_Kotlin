## Search a 2D Matrix


```
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val (m, n) = listOf(matrix.size, matrix[0].size)

        var left = 0
        var right = m * n - 1

        while (left <= right) {
            val mid = (left + right) / 2
            val midValue = matrix[mid / n][mid % n]

            if (midValue == target) {
                return true
            } else if (midValue < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return false
    }
}


```

**Оценка по времени**: О(log(m * n))


**Оценка по памяти**: О(1)


**Описание решения**
```

```