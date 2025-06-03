## 1450. Number of Students Doing Homework at a Given Time



``` 
class Solution {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var counter = 0

        for (i in 0 until startTime.size){
            if (queryTime >= startTime[i] && queryTime <= endTime[i]){
                counter++
            }
        }
        return counter
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

