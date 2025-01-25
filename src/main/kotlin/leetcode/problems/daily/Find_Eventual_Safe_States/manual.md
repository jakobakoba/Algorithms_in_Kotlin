## 802. Find Eventual Safe States


```
class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val safe = mutableMapOf<Int, Boolean>()
        val n = graph.size

        fun dfs(i: Int ): Boolean {
            if (i in safe){
                return safe[i]!!
            }

            safe[i] = false

            for (neighbor in graph[i]){
                if (dfs(neighbor) == false){
                    return safe[i]!!
                }
            }
            safe[i] = true
            return safe[i]!!
        }

        val res = mutableListOf<Int>()

        for (i in 0 until n){
            if (dfs(i)){
                res.add(i)
            }
        }
        return res

    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```