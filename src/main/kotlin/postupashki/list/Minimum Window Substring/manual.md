## 76. Minimum Window Substring


```
class Solution {
    fun minWindow(s: String, t: String): String {
        if (t == "") return ""
        val count = mutableMapOf<Char, Int>()
        for (char in t){
            count[char] = count.getOrDefault(char, 0) + 1
        }
        val window = mutableMapOf<Char,Int>()

        var have = 0
        val needed = count.size

        var res = intArrayOf(-1,-1)
        var resLen = Int.MAX_VALUE

        var left = 0
        for (right in 0 until s.length){
            val char = s[right]

            window[char] = window.getOrDefault(char, 0) + 1
            if (char in count && window[char]!! == count[char]!!){
                have++
            }

            while(have == needed){
                val charLeft = s[left]

                if (right - left + 1 < resLen){
                    resLen = right - left + 1
                    res = intArrayOf(left, right)
                }

                window[charLeft] = window[charLeft]!! - 1
                if (charLeft in count && window[charLeft]!! < count[charLeft]!!){
                    have--
                }
                left++
            }
        }
        
        return if (resLen == Int.MAX_VALUE) "" else s.substring(res[0], res[1] + 1)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) алфавит 26 букв


**Описание решения**
```

```

