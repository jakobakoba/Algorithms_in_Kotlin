## 2559. Count Vowel Strings in Ranges

solved myself
```
class Solution {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val n = words.size
        val prefix = IntArray(n + 1){0}
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        for (i in 0 until n){
            prefix[i + 1] = prefix[i] + if (words[i].first() in vowels && words[i].last() in vowels) 1 else 0
        }
        val m = queries.size
        val ans = IntArray(m)
        for (i in 0 until m){
            val query = queries[i]
            val start = query[0]
            val end = query[1]

            ans[i] = prefix[end + 1] - prefix[start]
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```