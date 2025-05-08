## 3341. Find Minimum Time to Reach Last Room I


```
class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size

        val time = Array(n){IntArray(m){Int.MAX_VALUE}}

        val comparator = compareBy<Triple<Int,Int,Int>>{it.first}
        val queue = PriorityQueue(comparator)

        time[0][0] = 0
        queue.add(Triple(0,0,0))

        while(queue.isNotEmpty()){
            val (curTime, r, c) = queue.poll()

            if (r == n - 1 && c == m - 1) return curTime

            if (curTime > time[r][c]) continue

            val neighbors = listOf(
                Pair(r + 1, c),
                Pair(r - 1, c), 
                Pair(r, c + 1),
                Pair(r, c - 1)
            )

            for ((nr, nc) in neighbors){
                if (nr !in 0 until n || nc !in 0 until m) continue

                val nextTime = maxOf(curTime, moveTime[nr][nc]) + 1
                if (nextTime < time[nr][nc]){
                    time[nr][nc] = nextTime
                    queue.add(Triple(nextTime, nr, nc))
                }
            }
        }
        return time[n-1][m-1]
    }
}

```

**Оценка по времени**: О(nm * log(nm))


**Оценка по памяти**: О(n * m)


**Описание решения**
```

```

