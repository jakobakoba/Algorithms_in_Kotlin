## Meeting Rooms (premium)

```
fun solveMeetingRoom(input: List<IntArray>): Int {
        val points = mutableListOf<Pair<Int,Int>>()
        for (meeting in input){
            points.add(Pair(meeting[0], 1))
            points.add(Pair(meeting[1], -1))
        }
        points.sortBy { it.first }

        var rooms = 0
        var temp = 0
        for (point in points){
            temp += point.second
            rooms = maxOf(rooms, temp)
        }
        return rooms
    }

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```
начальную точку интервала 0 делаем +1
конец интервала 1 делаем -1
и проходим по ней и находим максимум

```