## 443. String Compression


```
class Solution {
    fun compress(chars: CharArray): Int {
        val n = chars.size

        var pointer = 0

        var counter = 0
        for (i in 0 until n){
            counter++
            if (i == n - 1 || chars[i] != chars[i + 1]){
                chars[pointer] = chars[i]
                pointer++
                if (counter > 1){
                    val s = counter.toString()
                    for (ch in s){
                        chars[pointer] = ch
                        pointer++
                    }
                }
                counter = 0
            } 
        }
        return pointer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

