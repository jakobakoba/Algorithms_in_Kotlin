## 1446. Consecutive Characters


```
class Solution {
    fun maxPower(s: String): Int {
        var max = 1
        var temp = 1
        val n = s.length
        for (i in 1 until n){
            if (s[i] != s[i-1]){
                max = maxOf(max, temp)
                temp = 0
            } 
            temp++
        }
        return maxOf(max, temp)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```
коварная ловушка можно забыть что temp в конце не будет обработан после цикла и поэтому
можно вернуть maxOf(max, temp)
```

