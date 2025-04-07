## 771. Jewels and Stones


```
class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val set = mutableSetOf<Char>()
        for (char in jewels){
            set.add(char)
        }

        var count = 0

        for (char in stones){
            if (char in set){
                count++
            }
        }
        return count
    }
}

```

**Оценка по времени**: О(n + m)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

