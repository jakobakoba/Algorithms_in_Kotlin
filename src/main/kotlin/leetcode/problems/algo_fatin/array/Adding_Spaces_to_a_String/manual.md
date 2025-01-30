## 2109. Adding Spaces to a String


```
class Solution {
    fun addSpaces(s: String, spaces: IntArray): String {
        val set = spaces.toSet()
        val new = mutableListOf<Char>()
        for (i in 0 until s.length){
            if (set.contains(i)){
                new.add(' ')
            }
            new.add(s[i])
        }
        return new.joinToString("")
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```