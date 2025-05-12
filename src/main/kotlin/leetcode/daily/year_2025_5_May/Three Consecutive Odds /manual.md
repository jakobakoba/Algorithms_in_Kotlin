## 1550. Three Consecutive Odds



``` 
class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var count = 0 
        for (num in arr){
            if (num % 2 != 0){
                if (count == 2){
                    return true
                }
                count++
            } else {
                count = 0
            }
        }
        return false
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

