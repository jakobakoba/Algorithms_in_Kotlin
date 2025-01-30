## 1930. Unique Length-3 Palindromic Subsequences


```

class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val start = IntArray(26){-1}
        var end = IntArray(26)
        val n = s.length
        for (i in 0 until n){
            val index = s[i] - 'a'
            if (start[index] == -1) {
                start[index] = i
            }
            end[index] = i
        }

        val ans = mutableSetOf<String>()

        for (char in 'a' .. 'z'){
            val index = char - 'a'
            if (start[index] != -1){
                val first = start[index]
                val last = end[index]

                val visited = BooleanArray(26)
                for (i in first + 1 until last){
                    visited[s[i] - 'a'] = true
                }

                for (i in 0 until 26){
                    if (visited[i]){
                        ans.add("$char${'a' + i}$char")
                    }
                }
            }
        }
        return ans.size
    }
}
```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```