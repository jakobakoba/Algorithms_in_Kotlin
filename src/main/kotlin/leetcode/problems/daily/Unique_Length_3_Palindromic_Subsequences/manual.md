## 1930. Unique Length-3 Palindromic Subsequences


```

class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val n = s.length
        val set = mutableSetOf<String>()
        val start = IntArray(26){-1}
        val end = IntArray(26){-1}

        for (i in 0 until n){
            if (start[s[i] - 'a'] == -1) start[s[i] - 'a'] = i
            end[s[i] - 'a'] = i
        }

        for (char in 'a'..'z'){
            val seen = BooleanArray(26)

                for (i in start[char - 'a'] + 1 until end[char - 'a']){
                    seen[s[i] - 'a'] = true
                }
                for (i in 0 until 26){
                    if (seen[i] == true){
                        set.add("$char${'a' + i}$char")
                    }
                }

        }
        return set.size
    }
}
```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```