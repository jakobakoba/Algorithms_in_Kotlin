## 1314. Matrix Block Sum


```
class Solution {
    fun matrixBlockSum (mat: Array<IntArray>, k: Int) : Array<IntArray> {
        val (rows, cols) = intArrayOf(mat.size, mat[0].size)
        
        val pm = Array(rows + 1) {IntArray(cols + 1){0}}
        
        for (i in 0 until rows){
            for (j in 0 until cols){
                pm[i + 1][j + 1] = pm[i+1][j] + pm[i][j + 1] - pm[i][j] + mat[i][j]
            }
        }
        
        val new = Array(rows){IntArray(cols){0}}
        
        for (i in 0 until rows){
            for (j in 0 until cols){
                var x1 = if (i - k < 0) 0 else i - k
                var y1 = if (j - k < 0) 0 else j - k
                var x2 = if (i + k >= rows) rows else i + k + 1
                var y2 = if (j + k >= cols) cols else j + k + 1
                
                new[i][j] = pm[x2][y2] - pm[x2][y1] - pm[x1][y2] + pm[x1][y1]
            }
        }
        return new
    }
}


```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```