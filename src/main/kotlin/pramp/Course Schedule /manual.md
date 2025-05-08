## 207. Course Schedule


```
class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = mutableMapOf<Int,MutableList<Int>>()
        val degree = IntArray(numCourses)
        for (pre in prerequisites){
            adj.computeIfAbsent(pre[1]){mutableListOf()}.add(pre[0])
            degree[pre[0]]++
        }
        val queue: Queue<Int> = LinkedList()

        for (i in 0 until numCourses){
            if (degree[i] == 0){
                queue.add(i)
            }
        }
        var taken = 0
        while(queue.isNotEmpty()){
            val cur = queue.poll()
            taken++
            for (nei in adj[cur] ?: emptyList()){
                degree[nei]--
                if (degree[nei] == 0){
                    queue.add(nei)
                }
            }
        }
        return taken == numCourses
    }
}

```

**Оценка по времени**: О(V + E)
V = numCourses — количество вершин (курсов)
E = prerequisites.size — количество рёбер (зависимостей между курсами


**Оценка по памяти**: O(V + E)
adj — список смежности: максимум E рёбер
degree — массив на V курсов
queue — максимум V курсов может быть в очереди


**Описание решения**
```
Вы реализовали топологическую сортировку через алгоритм Кана (Kahn's Algorithm) — 
это классический способ определить, можно ли пройти все курсы без циклов (иначе говоря,
 существует ли топологический порядок для направленного графа).
```

