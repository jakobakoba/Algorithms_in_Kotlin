## 680. Valid Palindrome II



``` 
class Solution {

    fun check(str: String, l: Int, r: Int): Boolean {
        var left = l
        var right = r

        while(left <= right){
            if (str[left] != str[right]){
                return false
            }
            left++
            right--
        }
        return true
    }
    fun validPalindrome(s: String): Boolean {
        
        var left = 0
        var right = s.length - 1

        while(left <= right){
            if (s[left] != s[right]){
                return check(s, left + 1, right) || check(s, left, right - 1)
            }
            left++
            right--
        }
        return true
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

