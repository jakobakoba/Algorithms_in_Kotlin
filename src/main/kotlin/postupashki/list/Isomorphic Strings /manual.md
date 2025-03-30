## 205. Isomorphic Strings


```
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map1 = mutableMapOf<Char, Char>()
        val map2 = mutableMapOf<Char, Char>()

        for (i in 0 until s.length){
            val first = s[i] in map1 && map1[s[i]]!! != t[i]
            val second = t[i] in map2 && map2[t[i]]!! != s[i]

            if (first || second) return false

            map1[s[i]] = t[i]
            map2[t[i]] = s[i]
        }
        return true
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) алфавит 26 букв


**Описание решения**
```

```

