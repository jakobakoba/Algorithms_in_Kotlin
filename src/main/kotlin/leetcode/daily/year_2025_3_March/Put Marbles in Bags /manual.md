## 2551. Put Marbles in Bags


```
class Solution {
    fun putMarbles(weights: IntArray, k: Int): Long {

        val splits = mutableListOf<Long>()
        for (i in 0 until weights.size - 1){
            splits.add((weights[i] + weights[i + 1]).toLong())
        }
        splits.sort()
        val n = splits.size
        val starters = mutableListOf<Long>()
        for (i in 0 until k - 1){
            starters.add(splits[i])
        }
        val maxers = mutableListOf<Long>()
        for (i in n - 1 downTo n - (k - 1)){
            maxers.add(splits[i])
        }

        return maxers.sum() - starters.sum()
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

