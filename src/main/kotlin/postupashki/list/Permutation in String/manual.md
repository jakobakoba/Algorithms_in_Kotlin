## 567. Permutation in String

map
```

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val map = mutableMapOf<Char,Int>()

        for (char in s1){
            map[char] = map.getOrDefault(char, 0) + 1
        }

        val window = mutableMapOf<Char,Int>()

        var left = 0
        val k = s1.length

        for (right in 0 until s2.length){
            val char = s2[right]
            window[char] = window.getOrDefault(char, 0) + 1


            while(right - left + 1 > k){
                val leftChar = s2[left]
                window[leftChar] = window[leftChar]!! - 1

                if (window[leftChar]!! == 0){
                    window.remove(leftChar)
                }
                left++
            }

            if (window == map){
                return true
            }
        }
        return false
    }
}
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) алфавит 26 букв


**Описание решения**
```

```

