## 849. Maximize Distance to Closest Person


```
class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        val n = seats.size

        var max = 0
        var left = -1
        for (right in 0 until n){
            if(seats[right] == 1){
                if (left == -1){
                    max = right
                } else {
                    max = maxOf(max, (right - left) / 2 )
                }
                left = right
            }
        }
        if (seats[n-1] == 0){
            max = maxOf(max, n - 1 - left)
        }
        return max

        
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```
for the information:
если хотим рассчитать сколько элементов тогда right - left + 1
если хотим подсчитать шаги тогда right - left
```