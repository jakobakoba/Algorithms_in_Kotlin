## 1524. Number of Sub-arrays With Odd Sum



``` 
class Solution {
    fun numOfSubarrays(arr: IntArray): Int {
        val MOD =  1000000007

        var cur = 0

        var even = 0
        var odd = 0 

        var res = 0

        for (num in arr){
            cur += num

            // even
            if (cur % 2 == 0){
                res = (res + odd) % MOD
                even++
            } 
            //odd
            else {
                res = (res + 1 + even) % MOD
                odd++
            }
        }
        return res % MOD
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

