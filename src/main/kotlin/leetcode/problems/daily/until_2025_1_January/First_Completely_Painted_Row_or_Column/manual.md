## 2661. First Completely Painted Row or Column


```
class Solution {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val (n,m) = listOf(mat.size, mat[0].size)

        val positions = mutableMapOf<Int, Pair<Int,Int>>()

        for (i in 0 until n){
            for (j in 0 until m){
                positions[mat[i][j]] = Pair(i,j)
            }
        }

        val rows = IntArray(n){0}
        val cols = IntArray(m){0}

        for (i in 0 until arr.size){
            val (r, c) = positions[arr[i]]!!

            rows[r] += 1
            cols[c] += 1

            if (rows[r] == m || cols[c] == n){
                return i
            }
        }
        throw IllegalStateException("this line will never be reached")
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```