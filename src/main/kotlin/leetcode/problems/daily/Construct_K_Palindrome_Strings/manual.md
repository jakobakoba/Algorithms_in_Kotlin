## 1400. Construct K Palindrome Strings


```
class Solution {
    fun canConstruct(s: String, k: Int): Boolean {
        val n = s.length
        if (n < k) return false

        val chars = IntArray(26)
        for (i in 0 until n){
            chars[s[i] - 'a'] += 1
        }

        var odd = 0

        for (num in chars){
            if( num % 2 != 0) odd++
        }

        return odd <= k
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```
https://www.youtube.com/watch?v=D00qGvqmqN0

If oddCount <= k it's possible to form palindrome because we allocate
 one to each odd frequency character.
```