## 2185. Counting Words With a Given Prefix


```
class Solution {
    fun prefixCount(words: Array<String>, pref: String): Int {
        var ans = 0
        for (word in words){
            if (word.startsWith(pref)){
                ans++
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```