## 746. Min Cost Climbing Stairs

add 0 в конце и пойти с конца минус 2 шага
```
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        val new = IntArray(n + 1)
        for (i in 0 until n){
            new[i] = cost[i]
        }
        new[n] = 0
        for (i in n - 2 downTo 0){
            new[i] += minOf(new[i + 1], new[i + 2])
        }
        return minOf(new[0], new[1])
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

2 variables
```
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size

        var prev1 = cost[n - 2]
        var prev2 = cost[n - 1]

        for (i in n - 3 downTo 0){
            val cur = cost[i] + minOf(prev1, prev2)
            prev2 = prev1
            prev1 = cur
        }
        return minOf(prev1, prev2)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```