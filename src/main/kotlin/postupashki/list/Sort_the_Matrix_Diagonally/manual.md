## 1329. Sort the Matrix Diagonally


```
class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val (n, m) = listOf(mat.size, mat[0].size)
        
        for (k in 0 until n + m - 1){
            val diagonal = mutableListOf<Int>()
            
            val startRow = if( k < n) n - 1 - k else 0
            val startCol = if( k < n) 0 else k - n + 1
            
            var row = startRow
            var col = startCol
            
            while(row < n && col < m){
                diagonal.add(mat[row][col])
                row += 1
                col += 1
            }
            
            diagonal.sort()
            
            row = startRow
            col = startCol
            var i = 0
            while(row < n && col < m){
                mat[row][col] = diagonal[i]
                i++
                row++
                col++
            }
        }
        return mat
    }
}

```

**Оценка по времени**: О(nm log min(n, m))


**Оценка по памяти**: O(min(n, m))


**Описание решения**
```
 val startRow = if( k < n) n - 1 - k else 0
Если k < n (номер диагонали меньше количества строк):
Мы еще не дошли до верха матрицы, и начинаем в левом столбце, двигаясь вверх от низа.
Пока k маленький, мы начинаем с нижней строки и поднимаемся вверх. Как только дошли до верха, дальше всегда начинаем с верха (строка 0).

val startCol = if( k < n) 0 else k - n + 1
Если k < n:
Мы еще работаем в левом столбце, так что startCol = 0.
Если k >= n:
Мы уже использовали все строки в левом столбце и теперь начинаем сдвигаться вправо 
по верхней строке.
k - n + 1 — это сколько шагов вправо мы делаем от левого края.
Почему так?
k — это общее количество шагов от начала (левого нижнего угла).
n — это сколько шагов нужно, чтобы дойти до верха по левому столбцу.
k - n — это сколько шагов осталось после того, как мы дошли до верха.
+1 — потому что мы считаем первый шаг вправо как столбец 1 (а не 0).








```