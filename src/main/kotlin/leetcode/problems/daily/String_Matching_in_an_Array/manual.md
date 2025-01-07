## 1408. String Matching in an Array


```
class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        
        val n = words.size
        val res = mutableListOf<String>()
        for (i in 0 until n){
            for (j in 0 until n){
                if (i == j) continue

                if (words[i] in words[j]){
                    res.add(words[i])
                    break
                }
            }
        }
        return res
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```