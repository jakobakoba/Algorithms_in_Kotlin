## 3169. Count Days Without Meetings


```
class Solution {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        val sortedMeetings = meetings.sortedBy{it[0]}

        val stack = mutableListOf<IntArray>()

        for (meeting in sortedMeetings){
            if (stack.isEmpty()){
                stack.add(meeting)
            } else {
                val last = stack.last()
                val max = minOf(last[1], meeting[1])
                val min = maxOf(last[0], meeting[0])
                if (max >= min){
                    stack.removeLast()
                    val left = minOf(last[0], meeting[0])
                    val right = maxOf(last[1], meeting[1])
                    stack.add(intArrayOf(left,right))
                } else {
                    stack.add(meeting)
                }
            }
        }
        var counter = 0
        for (meeting in stack){
            counter += meeting[1] - meeting[0] + 1
        }
        return days - counter
    }
}


```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```
самая коварная ошибка при слиянии интервалов это > и >= Обязательно это учитывай.

```