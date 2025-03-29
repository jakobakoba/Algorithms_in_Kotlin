## 438. Find All Anagrams in a String


```
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val map = mutableMapOf<Char,Int>()

        for (char in p){
            map[char] = map.getOrDefault(char, 0) + 1
        }

        val window = mutableMapOf<Char,Int>()

        var left = 0
        val k = p.length
        val ans = mutableListOf<Int>()

        for (right in 0 until s.length){
            val char = s[right]
            window[char] = window.getOrDefault(char, 0) + 1

            while(right - left + 1 > k){
                val leftChar = s[left]
                window[leftChar] = window[leftChar]!! - 1
                if (window[leftChar] == 0) {
                    window.remove(leftChar)
                }
                left++
            }

            if (window == map){
                ans.add(left)
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) алфавит 26 букв


**Описание решения**
```

```

