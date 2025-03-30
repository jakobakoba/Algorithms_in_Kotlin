## 2818. Apply Operations to Maximize Score


```
class Solution {
    fun maximumScore(nums: List<Int>, k: Int): Int {
        val n = nums.size
        val MOD = 1_000_000_007
        var res = 1
        var k = k
        
        val primes = mutableListOf<Int>()
        for (n in nums){
            var score = 0
            
            for (f in 2 until sqrt(n).toInt() + 1){
                if (n % f == 0){
                    score += 1
                    while( n % f == 0){
                        n = n / f
                    }
                }
            }
            if (n >= 2){
                score += 1
            }
            primes.add(score)
        }
        
        val left = LongArray(n){-1L}
        val right = LongArray(n){n}
        
        val stack = mutableListOf<Int>()
        for ((i, value) in primes.withIndex()){
            while(stack.isNotEmpty() && primes[stack.last()] < value){
                val index = stack.poll()
                right[index] = i 
            }
            if (stack.isNotEmpty()){
                left[i] = stack.last()
            }
            stack.add(i)
        }
        
        val pq = PriorityQueue<Int,Int>(compareByDescending{it})
        
        while(k > 0){
            val (n, index) = pq.poll()
            var score = primes[index]
            
            val leftcount = index - left[index]
            val rightcount = right[index] - index
            
            val count = leftcount * rightcount
            val operations = minOf(count, k)
            
            res = (res * pow(n, operations, MOD)) % MOD
            k -= operations
        }
        
        return 
        
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```

