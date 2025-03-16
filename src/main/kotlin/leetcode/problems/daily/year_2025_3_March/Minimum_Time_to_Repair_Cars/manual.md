## 2594. Minimum Time to Repair Cars


```
class Solution {
    
    fun repairCars(ranks: IntArray, cars: Int): Long {
        fun count(time: Long): Long{
            var count = 0L
            for (rank in ranks){
                count += (sqrt(time / rank.toDouble())).toLong()
            }
            return count
        }
        var left = 1L
        var right = ranks[0].toLong() * cars * cars
        var res = -1L

        while(left <= right){
            val mid = (left + right) / 2L
            val repaired = count(mid)
            if(repaired >= cars){
                res = mid
                right = mid - 1
            } else {
                left = mid + 1
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

```