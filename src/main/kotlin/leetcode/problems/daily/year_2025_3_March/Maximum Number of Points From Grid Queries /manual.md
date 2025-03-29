## 2503. Maximum Number of Points From Grid Queries


```
class Solution {
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val (m, n) = listOf(grid.size, grid[0].size)

        val pq = PriorityQueue<Triple<Int,Int,Int>>(compareBy{it.first})
        pq.add(Triple(grid[0][0], 0, 0))

        val visited = mutableSetOf<Pair<Int,Int>>()
        visited.add(Pair(0,0))

        val sortedQueries = mutableListOf<Pair<Int,Int>>()
        for ((index, value) in queries.withIndex()){
            sortedQueries.add(Pair(value, index))
        }
        sortedQueries.sortBy{it.first}
        var points = 0
        val answer = IntArray(queries.size)
        for ((limit, index) in sortedQueries){
            while(pq.isNotEmpty() && pq.peek().first < limit){
                val (value, r, c) = pq.poll()
                points += 1
                val neighbors = listOf(
                    Pair(r + 1, c),
                    Pair(r - 1, c),
                    Pair(r, c - 1),
                    Pair(r, c + 1)
                )
                for ((nr, nc) in neighbors){
                    if (nr in 0 until m && nc in 0 until n && Pair(nr, nc) !in visited){
                        pq.add(Triple(grid[nr][nc], nr, nc))
                        visited.add(Pair(nr,nc))
                    }
                }
            }
            answer[index] = points
        }
        return answer
    }
}

```

**Оценка по времени**: О(qlogq + mnlogmn) which will be just O(mnlogmn)


**Оценка по памяти**: О(mn + q) which will be just O(mn)


**Описание решения**
```

```

