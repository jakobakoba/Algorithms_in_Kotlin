## 3442. Maximum Difference Between Even and Odd Frequency I



``` 
class Solution {
    fun maxDifference(s: String): Int {
        var odd = 0
        var even = Int.MAX_VALUE

        val map = mutableMapOf<Char,Int>()

        for (char in s){
            map[char] = map.getOrDefault(char, 0) + 1
        }

        for ((_, value) in map){
            if (value % 2 != 0 && value > odd){
                odd = value
            } else if (value % 2 == 0 && value < even){
                even = value
            }
        }
        return odd - even


    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

