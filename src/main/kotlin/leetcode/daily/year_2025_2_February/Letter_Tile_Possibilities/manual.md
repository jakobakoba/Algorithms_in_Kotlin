## 1079. Letter Tile Possibilities


```
class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val count = mutableMapOf<Char,Int>()

        for (ch in tiles){
            count[ch] = count.getOrDefault(ch, 0) + 1
        }

        fun backtrack(): Int{
            var res = 0
            for (ch in count.keys){
                if (count[ch]!! > 0){
                    count[ch] = count[ch]!! - 1
                    res++
                    res += backtrack()
                    count[ch] = count[ch]!! + 1
                }
            }
            return res
        }

        return backtrack()
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```