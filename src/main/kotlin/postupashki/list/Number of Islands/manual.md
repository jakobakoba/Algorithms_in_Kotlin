## 200. Number of Islands

bfs
```
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var ans = 0
        val (m, n) = listOf(grid.size, grid[0].size)

        val visited = mutableSetOf<Pair<Int,Int>>()
        fun bfs(i: Int, j: Int) {
            
            val queue: Queue<Pair<Int,Int>> = LinkedList()

            queue.add(i to j)
            visited.add(i to j)

            while(queue.isNotEmpty()){
                val (row, col) = queue.poll()
                val neighbors = listOf(
                    Pair(row + 1, col),
                    Pair(row - 1, col),
                    Pair(row, col + 1),
                    Pair(row, col - 1)
                )

                for ((nr, nc) in neighbors){
                    if (nr in 0 until m && nc in 0 until n && grid[nr][nc] == '1' && nr to nc !in visited){
                        queue.add(nr to nc)
                        visited.add(nr to nc)
                    }
                }
            }
        }

        for (i in 0 until m){
            for (j in 0 until n){
                if (grid[i][j] == '1' && i to j !in visited){
                    bfs(i,j)
                    ans++
                }
            }
        }
       
        return ans
    }
}

```

**Оценка по времени**: О(mn)


**Оценка по памяти**: О(mn)


**Описание решения**
```
если поменять на deque и делать pollfirst and addFirst то это будет dfs потому что 
dfs идет в одну сторону и потом backtrack
а bfs идет level by level

```

dfs
```
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size

        var counter = 0

        val visited = mutableSetOf<Pair<Int,Int>>()

        fun dfs(i : Int, j : Int) {
            visited.add(i to j)

            val neighbors = listOf(
                Pair(i + 1, j),
                Pair(i - 1, j),
                Pair(i, j + 1),
                Pair(i, j - 1),
            )

            for ((nr, nc) in neighbors){
                if (nr !in 0 until n || nc !in 0 until m || grid[nr][nc] == '0' || nr to nc in visited){
                    continue
                }
                dfs(nr, nc)
            }
        }
        for (i in 0 until n){
            for (j in 0 until m){
                if (grid[i][j] == '1' && i to j !in visited){
                    counter++
                    dfs(i, j)
                }
            }
        }
        return counter

    }
}
```

**Оценка по времени**: О(mn)


**Оценка по памяти**: О(mn)


**Описание решения**
```


```

сразу меняю grid на нули 
```
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size

        fun dfs(i: Int, j: Int){
            grid[i][j] = '0'

            val neighbors = listOf(
                Pair(i + 1, j),
                Pair(i - 1, j),
                Pair(i, j + 1),
                Pair(i, j - 1)
            )

            for ((nr, nc) in neighbors){
                if (nr !in 0 until n || nc !in 0 until m || grid[nr][nc] == '0'){
                    continue
                }
                dfs(nr,nc)
            }

        }

        var counter = 0
        for (i in 0 until n){
            for (j in 0 until m){
                if (grid[i][j] == '1'){
                    counter++
                    dfs(i,j)
                }
            }
        }
        return counter
    }
}
```

**Оценка по времени**: О(mn)


**Оценка по памяти**: О(mn)


**Описание решения**
```


```
