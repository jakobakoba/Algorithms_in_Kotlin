## 1422. Maximum Score After Splitting a String


```
class Solution {
    fun maxScore(s: String): Int {
        var left = 0
        var right = s.count{it == '1'}
        var ans = 0
        for (i in 0 until s.length - 1){
            if (s[i] == '0'){
                left += 1
            } else {
                right -= 1
            }

            ans = maxOf(ans, left + right)
        }
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```