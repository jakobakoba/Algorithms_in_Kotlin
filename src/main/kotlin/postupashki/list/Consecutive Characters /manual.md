## 1446. Consecutive Characters


```
class Solution {
    fun maxPower(s: String): Int {
        var max = 1
        var count = 1 

        for (i in 1 until s.length){
            if (s[i] == s[i-1]){
                count++
            } else {
                count = 1
            }
            max = maxOf(count, max)
        }
        return max
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

