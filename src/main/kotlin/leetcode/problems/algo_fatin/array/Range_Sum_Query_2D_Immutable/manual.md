## 304. Range Sum Query 2D - Immutable


```
class NumMatrix(matrix: Array<IntArray>){
    val rows = matrix.size
    val cols = matrix[0].size
    
    val pm = Array(rows + 1){IntArray(cols + 1){0}}
    
    init {
          for (i in 0 until rows){
            for (j in 0 until cols){
                pm[i + 1][j + 1] = pm[i + 1][j] + pm[i][j + 1] - pm[i][j] + matrix[i][j]      
            }
        }   
    }
   
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int) : Int {
        return pm[row2 + 1][col2 + 1] - pm[row1][col2 + 1] - pm[row2 + 1][col1] + pm[row1][col1]
    }
       
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```