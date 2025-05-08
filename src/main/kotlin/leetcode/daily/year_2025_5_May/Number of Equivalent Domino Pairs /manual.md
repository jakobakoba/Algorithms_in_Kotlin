## 1128. Number of Equivalent Domino Pairs


```
class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        for (i in 0 until dominoes.size){
            val up = minOf(dominoes[i][0], dominoes[i][1])
            val bottom = maxOf(dominoes[i][1], dominoes[i][0])
            dominoes[i] = intArrayOf(up, bottom)
        }
        dominoes.sortWith(compareBy({it[0]}, {it[1]}))

        var total = 0
        var cur = 1

        for (i in 1 until dominoes.size){
            if (dominoes[i][0] == dominoes[i-1][0] && dominoes[i][1] == dominoes[i-1][1]){
                cur++
            } else {
                total += cur * (cur - 1) / 2
                cur = 1
            }
        }
        total += cur * (cur - 1) / 2
        return total
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

