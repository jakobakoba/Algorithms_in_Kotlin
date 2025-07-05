## 59. Spiral Matrix II



``` 
class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        var left = 0
        var right = n - 1
        var top = 0
        var bottom = n - 1

        val matrix = Array(n){IntArray(n){0}}
        var counter = 1

        while(left <= right && top <= bottom){
            for (i in left .. right){
                matrix[top][i] = counter++
            }
            top++

            for (i in top .. bottom){
                matrix[i][right] = counter++
            }
            right--

            if (top <= bottom){
                for (i in right downTo left){
                    matrix[bottom][i] = counter++
                }
                bottom--
            }

            if (left <= right){
                for (i in bottom downTo top){
                    matrix[i][left] = counter++
                }
                left++
            }
        }
        return matrix

    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

