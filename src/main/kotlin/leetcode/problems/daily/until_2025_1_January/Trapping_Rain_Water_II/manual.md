## 407. Trapping Rain Water II


```
class Solution {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val (n, m) = listOf(heightMap.size, heightMap[0].size)

        val pq = PriorityQueue<Triple<Int,Int,Int>>(compareBy{it.first})

        for (i in 0 until n){
            for (j in 0 until m){
                if (i in listOf(0, n-1) || j in listOf(0, m-1)){
                    pq.add(Triple(heightMap[i][j], i, j))
                    heightMap[i][j] = -1
                }
            }
        }

        var res = 0
        var maxHeight = -1
        while(pq.isNotEmpty()){
            val (height, r, c) = pq.poll()
            maxHeight = maxOf(maxHeight, height)
            res += maxHeight - height

            val neighbors = listOf(
                Pair(r+1, c),
                Pair(r-1, c),
                Pair(r, c + 1),
                Pair(r, c - 1),
            )

            for ((nr, nc) in neighbors){
                if (nr < 0 || nc < 0 || nr == n || nc == m || heightMap[nr][nc] == -1){
                    continue
                }

                pq.add(Triple(heightMap[nr][nc], nr, nc))
                heightMap[nr][nc] = -1
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
https://www.youtube.com/watch?v=onA7_MaPGkM
```