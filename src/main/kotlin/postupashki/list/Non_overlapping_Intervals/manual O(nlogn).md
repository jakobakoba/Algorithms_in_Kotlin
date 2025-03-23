## 435. Non-overlapping Intervals


```
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy{it[1]}

        var count = 0
        val n = intervals.size
        var prev = intervals[0][1]
        for (i in 1 until n){
            if (intervals[i][0] < prev){
                count++
            } else {
                prev = intervals[i][1]
            }
        }
        return count
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(1)


**Описание решения**
```
мы сортируем по окончанию, потому что будем удалять того кто приходит потом 
то есть берем самого левого и на основе него со снайпером кемпуем тех кто на подходе и удаляем если intersection
потому что тот кто заканчивается позже он удаляется

```