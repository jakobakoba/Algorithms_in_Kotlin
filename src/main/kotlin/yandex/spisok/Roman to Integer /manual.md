## 13. Roman to Integer



``` 
class Solution {
    fun romanToInt(s: String): Int {
        var pointer = 0

        var ans = 0
        val map = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        while(pointer < s.length){
            if (pointer == s.length - 1){
                ans += map[s[pointer]]!!
                break
            }
            if (map[s[pointer]]!! < map[s[pointer + 1]]!!){
                ans += map[s[pointer + 1]]!! - map[s[pointer]]!!
                pointer++
                pointer++
            } else {
                ans += map[s[pointer]]!!
                pointer++
            }
        }
        return ans
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

