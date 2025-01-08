## 3042. Count Prefix and Suffix Pairs I


```
class Solution {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var ans = 0
        val n = words.size

        for (i in 0 until n){
            for (j in i + 1 until n){
                if (i != j && words[i].length <= words[j].length){
                    val first = words[i].length
                    val second = words[j].length

                    val prefix = words[j].substring(0, first)
                    val suffix = words[j].substring(second - first)

                    if (words[i] == prefix && words[i] == suffix){
                        ans++
                    }
                }
            }
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