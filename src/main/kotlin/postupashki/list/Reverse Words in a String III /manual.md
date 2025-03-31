## 557. Reverse Words in a String III

using helper functions
```
class Solution {
    fun reverseWords(s: String): String {
        val new = s.split(" ")
        val ans = mutableListOf<String>()

        for (str in new){
            ans.add(str.reversed())
        }

        return ans.joinToString(" ")
        
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

without helpers
```
class Solution {
    fun reverseWords(s: String): String {
        val s = s.toCharArray()
        val n = s.size

        var left = 0
        
        for (right in 0 until n){
            if (s[right] == ' ' || right == n - 1){
                var templeft = left
                var tempright = right - 1
                if (right == n - 1){
                    tempright = right
                }

                while(templeft < tempright){
                    s[templeft] = s[tempright].also{s[tempright] = s[templeft]}
                    templeft++
                    tempright--
                }
                left = right + 1
            }
        }

        return s.joinToString("")
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

