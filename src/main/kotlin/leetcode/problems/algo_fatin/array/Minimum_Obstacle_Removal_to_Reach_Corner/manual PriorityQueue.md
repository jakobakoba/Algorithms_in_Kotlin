## 2290. Minimum Obstacle Removal to Reach Corner



```
import java.util.*
class Solution{
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val (ROWS, COLS) = intArrayOf(grid.size, grid[0].size)
        
        val pq = PriorityQueue<Triple<Int,Int,Int>>(compareBy{it.first})
        pq.add(Triple(0,0,0))
        
        val visited = mutableSetOf<Pair<Int,Int>>()
        
        while(pq.isNotEmpty()){
        
            val (obstacles, r, c) = pq.poll()
            
            if (r == ROWS - 1 && c == COLS - 1) {
                return obstacles
            } 
            
            val neighbors = listOf(intArrayOf(r - 1, c), intArrayOf(r + 1, c), intArrayOf(r, c - 1), intArrayOf(r, c + 1))
            
            for ((nr, nc) in neighbors){
                if ( Pair(nr, nc) in visited || nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS ){
                    continue
                }
                pq.add(Triple(obstacles + grid[nr][nc], nr, nc))
                    visited.add(Pair(nr, nc))    
            }        
        }
        throw IllegalStateException(" ")
    }
}

```

**Оценка по времени**: О(n*m log(n*m))


**Оценка по памяти**: О(...)


**Описание решения**
```

с 0,0 нам важно направление только вниз и направо.
сверху неправильно, потому что потом можно и вверх и налево.
Если путь свободный, то ответ 0.
подсчитать все направления и выбрать с минимальными барьерами?
идей нет

neetcode:


```