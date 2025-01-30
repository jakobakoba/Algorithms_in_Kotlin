## 2658. Maximum Number of Fish in a Grid


```
class Solution {
    fun findMaxFish(grid: Array<IntArray>): Int {

        val (n, m) = listOf(grid.size, grid[0].size)

        val visited = mutableSetOf<Pair<Int,Int>>()
        var res = 0

        fun dfs(i: Int, j :Int): Int {
            if (i !in 0 until n || j !in 0 until m || grid[i][j] == 0 || i to j in visited){
                return 0
            }
            var num = grid[i][j]
            visited.add(Pair(i,j))

            val neighbors = listOf(
                Pair(i +1, j),
                Pair(i -1 , j),
                Pair(i , j + 1),
                Pair(i, j- 1),
            )

            for ((nr,nc) in neighbors){
                num += dfs(nr,nc)
            }
            return num
        }

        for (i in 0 until n){
            for (j in 0 until m){
                res = maxOf(res,dfs(i,j))         
            }
        }
        return res
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```