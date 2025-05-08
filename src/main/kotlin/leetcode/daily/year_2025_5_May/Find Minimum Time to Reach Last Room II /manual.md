## 3342. Find Minimum Time to Reach Last Room II


```
class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val (n, m) = listOf(moveTime.size, moveTime[0].size)

        val comparator = compareBy<Triple<Int,Int,Int>>{it.first}
        val queue = PriorityQueue(comparator)

        val time = Array(n){Array(m){IntArray(2){Int.MAX_VALUE}}}

        time[0][0][0] = 0
        queue.add(Triple(0,0,0))

        while(queue.isNotEmpty()){
            val (curTime, r, c) = queue.poll()

            if (r == n - 1 && c == m - 1) return curTime

            val type = if (curTime == time[r][c][0]) 0 else 1
            val nextStep = if (type == 0) 1 else 2

            val neighbors = listOf(
                Pair(r + 1, c),
                Pair(r - 1, c),
                Pair(r, c + 1),
                Pair(r, c - 1),
            )

            for ((nr, nc) in neighbors){
                if (nr !in 0 until n || nc !in 0 until m) continue

                val newTime = maxOf(curTime, moveTime[nr][nc]) + nextStep

                val newType = 1 - type

                if (newTime < time[nr][nc][newType]){
                    time[nr][nc][newType] = newTime
                    queue.add(Triple(newTime, nr, nc))
                }
            }
        }
        return -1


        
    }
}

```

**Оценка по времени**: О(nm * log(nm))


**Оценка по памяти**: О(nm)


**Описание решения**
```
в array [r][c][x] тут x значит следующий шаг если мы пришли в х то след шаг будет х
после выполнения шага мы переключаем для следующего шага.
Когда мы приходим в клетку, type говорит:
"Вот условия, при которых я сюда попал: следующий шаг должен быть X"

```

