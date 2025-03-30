## 827. Making A Large Island


```
class Solution {
    fun largestIsland(grid: Array<IntArray>): Int {
        val n = grid.size

        fun outOfBounds(r: Int, c: Int) : Boolean {
            return r !in 0 until n || c !in 0 until n
        }

        fun dfs(r: Int, c: Int, label: Int): Int {
            if (outOfBounds(r, c) || grid[r][c] != 1){
                return 0
            }
            grid[r][c] = label
            var size = 1
            val neighbors = listOf(
                Pair(r + 1, c),
                Pair(r - 1, c),
                Pair(r, c + 1),
                Pair(r, c -1),
            )
            for ((nr, nc) in neighbors){
                size += dfs(nr, nc, label)
            }
            return size
        }

        val size = mutableMapOf<Int,Int>()

        var label = 2

        for (r in 0 until n){
            for (c in 0 until n){
                if(grid[r][c] == 1){
                    size[label] = dfs(r, c, label)
                    label++
                }
            }
        }


        fun connect(r: Int, c: Int): Int {
            val neighbors = listOf(
                Pair(r + 1, c),
                Pair(r - 1, c),
                Pair(r, c + 1),
                Pair(r, c -1),
            )
            val visited = mutableSetOf<Int>()
            var result = 1
            for ((nr, nc) in neighbors){
                if (outOfBounds(nr,nc) == false && grid[nr][nc] !in visited){
                    result += size[grid[nr][nc]] ?: 0
                    visited.add(grid[nr][nc])
                }
            }
            return result
        }

        var res = size.values.maxOrNull() ?: 0


        for (r in 0 until n){
            for (c in 0 until n){
                if (grid[r][c] == 0){
                    res = maxOf(res, connect(r,c))            
                }
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
https://www.youtube.com/watch?v=pq61VNqXGvA

```