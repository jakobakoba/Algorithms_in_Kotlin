## 1267. Count Servers that Communicate

```
class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val (n, m) = listOf(grid.size, grid[0].size)

        val rows = IntArray(n)
        val cols = IntArray(m)

        var servers = 0

        for (i in 0 until n){
            for (j in 0 until m){
                if (grid[i][j] == 1){
                    servers += 1
                    rows[i]++
                    cols[j]++
                }
            }
        }


        for (i in 0 until n){
            for (j in 0 until m){
                if (grid[i][j] == 1){
                    if (rows[i] == 1 && cols[j] == 1) {
                        servers -= 1
                    }
                }
            }
        }
        return servers
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```