## 135. Candy


```
class Solution {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size

        val ans = IntArray(n){1}

        for (i in 1 until n){
            if (ratings[i] > ratings[i-1]){
                ans[i] = ans[i-1] + 1
            }
        }

        for (i in n - 2 downTo 0){
            if (ratings[i] > ratings[i + 1]){
                ans[i] = maxOf(ans[i], ans[i + 1] + 1)
            }
        }
        return ans.sum()
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

