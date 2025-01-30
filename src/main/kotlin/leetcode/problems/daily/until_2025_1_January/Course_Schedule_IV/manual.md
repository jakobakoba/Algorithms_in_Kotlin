## 1462. Course Schedule IV

```
class Solution {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val adj = mutableMapOf<Int,MutableList<Int>>()

        for((pre, course) in prerequisites){
            adj.computeIfAbsent(course){mutableListOf<Int>()}.add(pre)
        }
        val preMap = mutableMapOf<Int, MutableSet<Int>>()

        fun dfs(i: Int): Set<Int> {
            if (i !in preMap){
                 val prerequisites = mutableSetOf<Int>()
                  if (adj[i] != null) {
                    for (pre in adj[i]!!) {
                        prerequisites.addAll(dfs(pre))
                        }
                    }
                 prerequisites.add(i)
                 preMap[i] = prerequisites
            }

            return preMap[i]!!
        }

        val n = numCourses
        for (course in 0 until n){
            dfs(course)
        }

        val res = mutableListOf<Boolean>()
        for ((u, v) in queries){
            res.add(u in preMap[v] ?: mutableListOf())
        }
        return res
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=wYoZMBenHYY
```