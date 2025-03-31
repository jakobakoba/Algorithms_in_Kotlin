## 336. Palindrome Pairs


```
class Solution {
    fun isPalindrome(s: String, left: Int, right: Int): Boolean {
        var l = left
        var r = right
        while (l < r) {
            if (s[l] != s[r]) return false
            l++
            r--
        }
        return true
    }

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val indexMap = words.withIndex().associate { it.value to it.index }
        val result = mutableSetOf<List<Int>>()

    
        if ("" in indexMap) {
            val emptyIndex = indexMap[""]
            for ((i, word) in words.withIndex()) {
                if (i != emptyIndex && isPalindrome(word, 0, word.length - 1)) {
                    result.add(listOf(emptyIndex!!, i))
                    result.add(listOf(i, emptyIndex!!))
                }
            }
        }

        for ((i, word) in words.withIndex()) {
            val reversedWord = word.reversed()

          
            if (reversedWord in indexMap && indexMap[reversedWord] != i) {
                result.add(listOf(i, indexMap[reversedWord]!!))
            }

            val n = word.length
            for (j in 1 until n) {
                val left = word.substring(0, j)
                val right = word.substring(j)

             
                if (isPalindrome(left, 0, left.length - 1) && right.reversed() in indexMap) {
                    val matchIndex = indexMap[right.reversed()]!!
                    if (matchIndex != i) result.add(listOf(matchIndex, i))
                }

                if (isPalindrome(right, 0, right.length - 1) && left.reversed() in indexMap) {
                    val matchIndex = indexMap[left.reversed()]!!
                    if (matchIndex != i) result.add(listOf(i, matchIndex))
                }
            }
        }

        return result.toList()
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```



```

