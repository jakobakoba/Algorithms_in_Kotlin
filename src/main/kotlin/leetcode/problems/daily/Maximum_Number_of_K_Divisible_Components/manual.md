## 2872. Maximum Number of K-Divisible Components


```
class Solution {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val adj = mutableMapOf<Int, MutableList<Int>>()

     
        for ((a, b) in edges) {
            adj.computeIfAbsent(a) { mutableListOf() }.add(b)
            adj.computeIfAbsent(b) { mutableListOf() }.add(a)
        }

        var ans = 0


        fun dfs(cur: Int, parent: Int): Long {
            var total: Long = values[cur].toLong() 

            adj[cur]?.forEach { child ->
                if (child != parent) {
                    total += dfs(child, cur)
                }
            }

            if (total % k == 0L) {
                ans++
            }
            return total
        }

        dfs(0, -1)
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
Int не проходит, надо переводить в Long

https://www.youtube.com/watch?v=xlgOaIK-inc
```