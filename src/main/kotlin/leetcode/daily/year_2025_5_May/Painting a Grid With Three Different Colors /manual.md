## 1931. Painting a Grid With Three Different Colors



``` 
class Solution {
    fun colorTheGrid(m: Int, n: Int): Int {
        val MOD = 1000000007
        
        val validStates = generate(m)
        val numStates = validStates.size
        if (numStates == 0) return 0
        
        val transition = Array(numStates){mutableListOf<Int>()}
        for (curIdx in 0 until numStates){
            val curState = validStates[curIdx]
            for (prevIdx in 0 until numStates){
                val prevState = validStates[prevIdx]
                var compatible = true
                for (i in 0 until m){
                    if (prevState[i] == curState[i]){
                        compatible = false
                        break
                    }
                }
                if (compatible){
                    transition[curIdx].add(prevIdx)
                }
            }
        }
        var dp = LongArray(numStates){1}
        
        for (col in 1 until n){
            val dpCur = LongArray(numStates)
            for (curIdx in 0 until numStates){
                var sum = 0L
                for (prevIdx in transition[curIdx]){
                    sum = (sum + dp[prevIdx]) % MOD
                }
                dpCur[curIdx] = sum
            }
            dp = dpCur
        }
        
        var total = 0L
        for (count in dp){
            total = (total + count) % MOD
        }
        return total.toInt()
    }
    
    private fun generate(m: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(current: MutableList<Int>){
            if (current.size == m){
                result.add(current.toList())
                return
            }
            for (color in 0 .. 2){
                if (current.isEmpty() || color != current.last()){
                    current.add(color)
                    backtrack(current)
                    current.removeAt(current.size - 1)
                }
            }
        }
        backtrack(mutableListOf())
        return result
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

