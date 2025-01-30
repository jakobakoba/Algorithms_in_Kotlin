## 1765. Map of Highest Peak


```
class Solution {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val (n, m) = listOf(isWater.size, isWater[0].size)

        val queue: Queue<Pair<Int,Int>> = LinkedList()

        val res = Array(n){IntArray(m){-1}}

        for (i in 0 until n){
            for (j in 0 until m){
                if (isWater[i][j] == 1){
                    queue.add(Pair(i,j))
                    res[i][j] = 0
                }
            }
        }

        while(queue.isNotEmpty()){
            val (r, c) = queue.poll()
            val height  = res[r][c]

            val neighbors = listOf(
                Pair(r + 1, c),
                Pair(r - 1, c),
                Pair(r, c + 1),
                Pair(r, c - 1),
            )
            for ((nr, nc) in neighbors){
                if (nr !in 0 until n || nc !in 0 until m || res[nr][nc] != -1){
                    continue
                }

                queue.add(Pair(nr,nc))
                res[nr][nc] = height + 1
            }
        }
        return res
    }
}

```

**Оценка по времени**: О(n*m)


**Оценка по памяти**: О(n*m)


**Описание решения**
```
https://www.youtube.com/watch?v=cQRZ202j-kA
```