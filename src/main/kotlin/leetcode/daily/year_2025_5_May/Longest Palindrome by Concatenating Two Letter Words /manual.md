## 2131. Longest Palindrome by Concatenating Two Letter Words



``` 
class Solution {
    fun longestPalindrome(words: Array<String>): Int {
        val map = mutableMapOf<String, Int>()

        for (word in words){
            map[word] = map.getOrDefault(word, 0) + 1
        }

        var length = 0
        var center = false

        for ((word, count) in map){
            val reversed = word.reversed()

            if (word == reversed){
                length += (count / 2) * 4
                if (count % 2 == 1){
                    center = true
                }
            } else if (word < reversed){
                val pair = minOf(count, map[reversed] ?: 0)
                length += pair * 4
            }
        }
        if (center){
            length += 2
        }
        return length
    }
}

```

**Оценка по времени**: O(n + m)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

