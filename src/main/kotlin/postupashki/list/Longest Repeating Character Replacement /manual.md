## 424. Longest Repeating Character Replacement

```
class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val n = s.length

        val map = mutableMapOf<Char,Int>()

        var left = 0
        var max = 0
        var res = 0

        for (right in 0 until n){
            map[s[right]] = map.getOrDefault(s[right], 0) + 1
            max = maxOf(max, map[s[right]]!!)

            while((right - left + 1) - max > k){
                map[s[left]] = map[s[left]]!! - 1
                left += 1
            }

            res = maxOf(res, right - left + 1)
        }
        return res
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) алфавит 26 букв


**Описание решения**
```

```

