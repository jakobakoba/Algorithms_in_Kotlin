## 1358. Number of Substrings Containing All Three Characters


```
class Solution {
    fun numberOfSubstrings(s: String): Int {
        var (a, b, c) = listOf(-1, -1, -1)

        val n = s.length
        var ans = 0

        for (i in 0 until n){
            when(s[i]){
                'a' -> a = i
                'b' -> b = i
                'c' -> c = i
            }

            val min = minOf(a,b,c)
            ans += min + 1
        }
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```