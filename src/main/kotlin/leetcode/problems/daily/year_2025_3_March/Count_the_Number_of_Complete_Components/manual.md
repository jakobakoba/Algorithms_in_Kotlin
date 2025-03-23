## 2685. Count the Number of Complete Components


```
class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {

        val adj = mutableMapOf<Int, MutableList<Int>>()
        for ((a,b) in edges){
            adj.computeIfAbsent(a){mutableListOf<Int>()}.add(b)
            adj.computeIfAbsent(b){mutableListOf<Int>()}.add(a)
        }

        val visited = mutableSetOf<Int>()
        fun dfs(v: Int, res: MutableList<Int>) {
            if (v in visited) return

            visited.add(v)
            res.add(v)
            adj[v]?.forEach{
                dfs(it, res)
            }
        }

        var ans = 0
        for (i in 0 until n){
            if (i in visited){
                continue
            }
            val component = mutableListOf<Int>()
            dfs(i, component)

            if (component.all{adj.getOrDefault(it, emptyList()).size == component.size - 1}){
                ans++
            }
        }
        return ans

    }
}

```

**Оценка по времени**: О(n + m)


**Оценка по памяти**: О(n + m)


**Описание решения**
```

```