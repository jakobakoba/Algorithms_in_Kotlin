## 3169. Count Days Without Meetings


```

another way:
class Solution {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        meetings.sortBy{it[0]}
        var prev = 0
        var days = days
        for (meeting in meetings){
            var (start, end) = meeting

            start = maxOf(start, prev + 1)
            val length = end - start + 1
            days -= maxOf(length, 0)
            prev = maxOf(prev, end)
        }
        return days
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```