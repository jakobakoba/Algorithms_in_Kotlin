## 1014. Best Sightseeing Pair


```
class Solution {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        var res = 0
        var cur = values[0] - 1

        for (i in 1 until values.size){
            res = maxOf(res, values[i] + cur)
            cur = maxOf(cur - 1, values[i] - 1)
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