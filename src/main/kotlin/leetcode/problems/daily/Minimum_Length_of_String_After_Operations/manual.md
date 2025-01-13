## 3223. Minimum Length of String After Operations


```
class Solution {
    fun minimumLength(s: String): Int {
        val chars = IntArray(26)
        val n = s.length
        for (i in 0 until n){
            chars[s[i] - 'a'] ++
        }
        var ans = 0

        for (num in chars){
            ans += if (num == 0) 0 else if (num % 2 == 0) 2 else 1
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