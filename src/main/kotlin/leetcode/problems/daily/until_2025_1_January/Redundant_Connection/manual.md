## 684. Redundant Connection

```
class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val par = IntArray(n + 1){it}

        val rank = IntArray(n + 1){1}

        fun find(x: Int): Int {
            if (x == par[x]){
                return par[x]
            }
            par[x] = find(par[x])
            return par[x]
        }

        fun union(x1: Int, x2: Int): Boolean {
            val (p1, p2) = listOf(find(x1), find(x2))

            if (p1 == p2) {
                return false
            }
            if (rank[p1] > rank[p2]){
                par[p2] = p1
                rank[p1] += rank[p2]
            } else {
                par[p1] = p2
                rank[p2] += rank[p1]
            }
            return true
        }

        for ((x1, x2) in edges){
            if (union(x1,x2) == false){
                return intArrayOf(x1,x2)
            }
        }
        throw IllegalStateException("")
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```