## 2683. Neighboring Bitwise XOR


```
class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        var start = 0
        var last = 0

        for (num in derived){
            if (num == 1){
                last = last xor 1
            }
        }
        return start == last
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```