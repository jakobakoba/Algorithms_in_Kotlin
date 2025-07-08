## 1572. Matrix Diagonal Sum



``` 
class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var sum = 0
        val n = mat.size
        var i = 0
        var j = 0
        while(i < n && j < n){
            sum += mat[i][j]
            i++
            j++
        }

        i = 0
        j = n - 1
        
        while(i < n && j >= 0){
            sum += mat[i][j]
            i++
            j--
        }
        
        return sum - if (n % 2 != 0) mat[n/2][n/2] else 0
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)  


**Описание решения**
```

```

