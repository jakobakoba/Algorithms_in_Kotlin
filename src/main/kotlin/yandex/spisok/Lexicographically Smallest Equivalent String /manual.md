## 1061. Lexicographically Smallest Equivalent String



``` 
class Solution {
    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val map = mutableMapOf<Char,Char>()

        for (i in 'a' .. 'z'){
            map[i] = i
        }

        fun find(char: Char): Char{
            if (map[char]!! != char){
                map[char] = find(map[char]!!)
            }
            return map[char]!!
        }

        fun union(a: Char, b: Char) {
            val p1 = find(a)
            val p2 = find(b)

            if (p1 != p2){
                if (p1 < p2){
                    map[p2] = p1
                } else {
                    map[p1] = p2
                }
            }
        }

        for (i in 0 until s1.length){
            union(s1[i], s2[i])
        }

        val result = StringBuilder()
        for (char in baseStr){
            val s = find(char)
            result.append(s)
        }
        return result.toString()
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

