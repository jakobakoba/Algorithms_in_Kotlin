## 9. Palindrome Number


```
class Solution {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        var left = 0
        var right = s.length - 1

        while(left < right){
            if (s[left] != s[right]){
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


**Оценка по памяти**: О(n)


**Описание решения**
```

```

reversed string
```
class Solution {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        val reversed = s.reversed()

        return s == reversed
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```
reverse integer (гениально)
```
class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var original = x
        var reversed = 0
        while(original > 0){
            reversed = reversed * 10 + original % 10
            original /= 10
        }
        return x == reversed
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```