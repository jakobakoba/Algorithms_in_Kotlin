## 463. Island Perimeter

```
class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        val visited = mutableSetOf<Pair<Int,Int>>()
        val (m, n) = listOf(grid.size, grid[0].size)

        fun dfs(i: Int, j: Int): Int {
            if (i !in 0 until m || j !in 0 until n || grid[i][j] == 0 ) {
                return 1
            }

            if (i to j in visited){
                return 0
            }
            visited.add(i to j)


            var ans = dfs(i + 1, j)
            ans += dfs(i - 1, j)
            ans += dfs(i, j + 1)
            ans += dfs(i, j - 1)

            return ans
        }

        for (i in 0 until m){
            for (j in 0 until n){
                if (grid[i][j] == 1){
                    return dfs(i,j)
                }
            }
        }
        throw IllegalStateException(" ")
    }
}

```

**Оценка по времени**: О(mn)


**Оценка по памяти**: О(mn)


**Описание решения**
```

```

