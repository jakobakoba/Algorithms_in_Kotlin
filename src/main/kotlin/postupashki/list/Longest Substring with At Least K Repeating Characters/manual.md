## 395. Longest Substring with At Least K Repeating Characters


```
class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        var ans = 0

        for (unique in 1 .. 26){
            val map = mutableMapOf<Char,Int>()
            var left = 0
            for ((right, char) in s.withIndex()){
                map[char] = map.getOrDefault(char, 0) + 1

                while(map.size > unique){
                    val leftChar = s[left]
                    map[leftChar] = map[leftChar]!! - 1
                    if (map[leftChar]!! == 0){
                        map.remove(leftChar)
                    }
                    left++
                }

                var legit = true
                for ((ch, count) in map){
                    if (count < k){
                        legit = false
                        break
                    }
                }
                if (legit){
                    ans = maxOf(ans, right - left + 1)
                }
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(26 * n) -> O(n)


**Оценка по памяти**: О(26) -> O(1)


**Описание решения**
```

```

