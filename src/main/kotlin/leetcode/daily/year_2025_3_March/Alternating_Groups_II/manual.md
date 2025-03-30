## 3208. Alternating Groups II

```
class Solution {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val n = colors.size

        val extended = IntArray(n + k - 1)
        for (i in 0 until n){
            extended[i] = colors[i]
        }
        for (i in 0 until k - 1){
            extended[n + i] = colors[i]
        }

        var count = 0

        var valid = true

        for (i in 1 until k){
            if (extended[i] == extended[i - 1]){
                valid = false
                break
            }
        }
        if (valid) count++

        for (i in 1 until n){
            if (valid){
                if (extended[i + k - 1] == extended[i + k - 2]){
                    valid = false
                }
            } else {
                valid = true
                for (j in i + 1 until i + k){
                    if (extended[j] == extended[j - 1]){
                        valid = false
                        break
                    }
                }
            }
            if (valid) count++
        }
        return count
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```