## 2379. Minimum Recolors to Get K Consecutive Black Blocks


```
class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        val n = blocks.length
        var min = Int.MAX_VALUE
        var temp = 0
        var left = 0
        var right = 0
        repeat(k){
            if (blocks[right] == 'W'){
                temp += 1
            }
            right++
        }

        min = minOf(temp, min)

        while(right < n){
            
            if (blocks[right] == 'W'){
                temp++
            }
            if (blocks[left] == 'W'){
                temp--
            }
            right++
            left++
            min = minOf(min, temp)
        }
        return min
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```