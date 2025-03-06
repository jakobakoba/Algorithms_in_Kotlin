## 1368. Minimum Cost to Make at Least One Valid Path in a Grid


```
class Solution {
    fun minCost(grid: Array<IntArray>): Int {
        val (n, m) = listOf(grid.size, grid[0].size)

        val directions = mapOf(
            1 to Pair(0, 1),
            2 to Pair(0, -1),
            3 to Pair(1, 0),
            4 to Pair(-1, 0),
        )

        val deque: Deque<Triple<Int,Int,Int>> = LinkedList()
        deque.add(Triple(0,0,0))

        val minCost = mutableMapOf(Pair(0,0) to 0)

        while(deque.isNotEmpty()){
            val (r, c, cost) = deque.removeFirst()
            if (r == n-1 && c == m - 1 ) return cost

            for (d in directions.keys){
                val (dr, dc) = directions[d]!!

                val (nr, nc) = listOf(r + dr, c + dc)

                val newCost = if (d == grid[r][c]) cost else cost + 1

                if (nr < 0 || nc < 0 || nr == n || nc == m
                    || newCost >= minCost.getOrDefault(nr to nc, Int.MAX_VALUE)
                ){
                    continue
                }

                minCost[nr to nc] = newCost

                if (d == grid[r][c]){
                    deque.addFirst(Triple(nr, nc, newCost))
                } else {
                    deque.addLast(Triple(nr, nc, newCost))
                }
             }
    }
    return -1
}
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
0-1 BFS используется

https://www.youtube.com/watch?v=3DwA6AsQvDI
```