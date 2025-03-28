## 387. First Unique Character in a String

map
```
class Solution {
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char,Int>()
        for (char in s){
            map[char] = map.getOrDefault(char, 0) + 1
        }
        for (i in 0 until s.length){
            if (map[s[i]] == 1){
                return i
            }
        }
        return -1
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```