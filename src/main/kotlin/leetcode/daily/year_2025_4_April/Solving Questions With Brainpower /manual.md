## 2140. Solving Questions With Brainpower


```
class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val n = questions.size
        val cache = LongArray(n)
        
        fun backtrack(i: Int): Long {
            if (i >= n){
                return 0L
            }
            if (cache[i] != 0L){
                return cache[i]
            }
            
            var (points, brainpower) = questions[i]
            val skip = backtrack(i + 1)
            val choose = points + backtrack(i + 1 + brainpower)
            cache[i] = maxOf(skip, choose)
            return cache[i]
        }
        
        return backtrack(0)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

