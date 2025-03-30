## 2381. Shifting Letters II

```
class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val n = s.length
        val prefix = IntArray(n + 1)

    
        for ((left, right, diff) in shifts) {
            prefix[left] += if (diff > 0) 1 else -1
            prefix[right + 1] += if (diff > 0) -1 else 1
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

At prefix[start], you add the shift (increase or decrease the cumulative value starting from start).
At prefix[end + 1], you subtract the shift (reverse the effect after the range end). 
Using end + 1 ensures the shift applies only within the range [start, end]
This ensures that the shift only applies between start and end when we later calculate 
cumulative values.

!!! val shift = (prefix[i] % 26 + 26) % 26 
Why % 26?
Since there are only 26 letters in the alphabet, a shift of 26 (or any multiple of 26) 
doesn't change the letter.
For example, shifting 'a' by 26 positions gives 'a' again. So, % 26 ensures 
the shift stays within the range [0, 25].

Why + 26 and another % 26?
If prefix[i] is negative (e.g., left shift), adding 26 makes it positive, 
ensuring that the result of the % 26 operation is always a valid index in the alphabet.
For example, a shift of -1 becomes 25 when calculated as (-1 + 26) % 26.

!!! val newChar = 'a' + (s[i] - 'a' + shift) % 26
s[i] - 'a': This converts the current character to a numeric value.
For example, 'a' becomes 0, 'b' becomes 1, ..., 'z' becomes 25.

s[i] - 'a' + shift: Adds the shift to the numeric value of the character.
For example, if the character is 'b' (1) and the shift is 2, the result becomes 3 
(which corresponds to 'd').

(s[i] - 'a' + shift) % 26: Ensures the result wraps around the alphabet if it goes past 'z'.
For example, shifting 'z' (25) by 1 gives 0, which corresponds to 'a'.

'a' + ...: Converts the numeric result back to a character.
For example, 0 becomes 'a', 1 becomes 'b', ..., 25 becomes 'z'.
```