## 2657. Find the Prefix Common Array of Two Arrays



``` 
class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        val freq = IntArray(n + 1)

        val ans = IntArray(n)

        var common = 0

        for (i in 0 until n){
            val firstValue = A[i]
            val secondValue = B[i]

            
            freq[firstValue]++
            if (freq[firstValue] == 2) common++
            freq[secondValue]++
            if (freq[secondValue] == 2) common++

            ans[i] = common
        }
        return ans
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(n)


**Описание решения**
```

```

