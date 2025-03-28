## 125. Valid Palindrome

```
class Solution {
    fun isPalindrome(s: String): Boolean {
        val n = s.length        
        var left = 0
        var right = n - 1

        while(left < right){
            while(left < right && !s[left].isLetterOrDigit()){
                left++
            }
            while(left < right && !s[right].isLetterOrDigit()){
                right--
            }
            
            if (s[left].lowercase() != s[right].lowercase()){
                return false
            }
            left++
            right--
        }
        return true
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```