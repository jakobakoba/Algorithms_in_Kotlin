## 763. Partition Labels


```
class Solution {
    fun partitionLabels(s: String): List<Int> {
        val n = s.length

        val map = mutableMapOf<Char,Int>()
        for (i in 0 until n){
            map[s[i]] = i
        }

        var size = 0
        var end = 0
        val ans = mutableListOf<Int>()
        for (i in 0 until n){
            size++
            end = maxOf(end, map[s[i]]!!)
            if (i == end){
                ans.add(size)
                size = 0
            }
        }
        return ans

        
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) алфавит 26 букв


**Описание решения**
```
не забудь нуллабельность у мапы

```

