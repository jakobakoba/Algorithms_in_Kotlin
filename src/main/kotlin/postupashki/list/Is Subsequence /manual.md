## 392. Is Subsequence


```
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var p1 = 0
        var p2 = 0

        val n1 = s.length
        val n2 = t.length

        while(p1 < n1 && p2 < n2){
            if (s[p1] == t[p2]){
                p1++
            }
            p2++
        }
        return p1 == n1
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```