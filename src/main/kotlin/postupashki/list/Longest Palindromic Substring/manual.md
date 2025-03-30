## 5. Longest Palindromic Substring


```
class Solution {
    fun longestPalindrome(s: String): String {
        
        val n = s.length
        var res = intArrayOf(-1,-1)
        var max = 0
        for (i in 0 until n){

            var left = i
            var right = i

            while(left >= 0 && right < n && s[left] == s[right]){
                if (right - left + 1 > max){
                    max = right - left + 1
                    res = intArrayOf(left, right)
                }
                left--
                right++
            }

            left = i
            right = i + 1
            while(left >= 0 && right < n && s[left] == s[right]){
                if (right - left + 1 > max){
                    max = right - left + 1
                    res = intArrayOf(left, right)
                }
                left--
                right++
            }
        }
        return s.substring(res[0], res[1] + 1)
    }
}

```

**Оценка по времени**: О(n^2)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

