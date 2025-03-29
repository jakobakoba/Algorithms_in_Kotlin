## 3. Longest Substring Without Repeating Characters

map
```
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char,Int>()
        var max = 0
        var left = 0
        for (right in 0 until s.length){
            val rightChar = s[right]
            map[rightChar] = map.getOrDefault(rightChar, 0) + 1

            while(map[rightChar]!! > 1){
                map[s[left]] = map[s[left]]!! - 1
                left++
            }

            max = maxOf(max, right - left + 1)
        }
        return max
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

set
```
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var left = 0
        var max = 0
        for (right in 0 until s.length){
            val char = s[right]

            while (char in set){
                set.remove(s[left])
                left++
            }
            set.add(char)
            max = maxOf(max, right - left + 1)
        }
        return max
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

