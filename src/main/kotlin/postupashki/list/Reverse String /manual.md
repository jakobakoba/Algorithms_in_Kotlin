## 344. Reverse String


```
class Solution {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1

        while(left < right){
            s[left] = s[right].also{s[right] = s[left]}
            left++
            right--
        }
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```