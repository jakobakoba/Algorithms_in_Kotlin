## 73. Set Matrix Zeroes


``` 
class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        
        val n = matrix.size
        val m = matrix[0].size

        val rows = mutableSetOf<Int>()
        val cols = mutableSetOf<Int>()

        for (i in 0 until n){
            for (j in 0 until m){
                if (matrix[i][j] == 0){
                    rows.add(i)
                    cols.add(j)
                }
            }
        }

        for (i in 0 until n){
            for (j in 0 until m){
                if (i in rows || j in cols){
                    matrix[i][j] = 0
                }
            }
        }
    }
}

```

**Оценка по времени**: O(m × n)


**Оценка по памяти**: O(m × n)


**Описание решения**
```

```

