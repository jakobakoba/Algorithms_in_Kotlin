## 2523. Closest Prime Numbers in Range


```
import kotlin.math.sqrt

class Solution {
    fun getPrimes(start: Int, end: Int): List<Int>{
        val primes = mutableListOf<Int>()

        val isPrime = BooleanArray(end + 1){true}
        isPrime[0] = false
        isPrime[1] = false

        for (p in 2 .. sqrt(end.toDouble()).toInt()){
            if (isPrime[p]){
                for (i in p * p .. end step p){
                    isPrime[i] = false
                }
            }
        }

        for (i in start .. end){
            if (isPrime[i]){
                primes.add(i)
            }
        }
        return primes
    }
    fun closestPrimes(left: Int, right: Int): IntArray {
       val primes =  getPrimes(left, right)

        var minDiff = Int.MAX_VALUE
        var ans = intArrayOf(-1,-1)

        for (i in 0 until primes.size - 1){
            val diff = primes[i + 1] - primes[i]
            if (diff < minDiff){
                minDiff = diff
                ans = intArrayOf(primes[i], primes[i + 1])
            }    
        }
        return ans

    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```