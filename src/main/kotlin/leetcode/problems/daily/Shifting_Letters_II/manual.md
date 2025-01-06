## 2381. Shifting Letters II

```
class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val n = s.length
        val prefix = IntArray(n + 1)

    
        for ((left, right, diff) in shifts) {
            prefix[left] += if (diff > 0) 1 else -1
            prefix[right + 1] -= if (diff > 0) 1 else -1
        }

 
        var cumulativeShift = 0
        for (i in 0 until n) {
            cumulativeShift += prefix[i]
            prefix[i] = cumulativeShift
        }

        val result = StringBuilder()
        for (i in 0 until n) {
            val shift = (prefix[i] % 26 + 26) % 26 
            val newChar = 'a' + (s[i] - 'a' + shift) % 26
            result.append(newChar)
        }

        return result.toString()
    }
}


```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
https://www.youtube.com/watch?v=eEUjVY7wK3k
```