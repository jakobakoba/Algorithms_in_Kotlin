## 48. Rotate Image


```
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        var (left, right) = listOf(0, matrix.size - 1)

        while(left < right){
            val (top, bottom) = listOf(left, right)

            for (i in 0 until right - left){

                val topLeft = matrix[top][left + i]

                matrix[top][left + i] = matrix[bottom - i][left]
                matrix[bottom - i][left] = matrix[bottom][right-i]
                matrix[bottom][right-i] = matrix[top+i][right]
                matrix[top+i][right] = topLeft
            }
            left++
            right--
        } 
    }
}

second way (transpose and reverse):
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        for (i in 0 until n){
            for (j in i + 1 until n){
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        for (i in 0 until n){
            var left = 0
            var right = n - 1
            while(left < right){
                matrix[i][left] = matrix[i][right].also{matrix[i][right] = matrix[i][left]}
                left++
                right--
            }
        }
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```