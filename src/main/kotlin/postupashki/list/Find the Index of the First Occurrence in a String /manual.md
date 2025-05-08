## Find the Index of the First Occurrence in a String


```
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val n = haystack.length
        val m = needle.length

        if (m == 0){
            return 0
        }
        if (m > n) return -1

        for (i in 0 .. (n - m)){
            if(haystack.substring(i, i + m) == needle){
                return i
            }
        }
        return -1
    }
}

```

**Оценка по времени**: О(n * m)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

