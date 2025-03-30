## 2493. Divide Nodes Into the Maximum Number of Groups


```
class Solution {
    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
        val adj = mutableMapOf<Int,MutableList<Int>>()

        for ((a, b) in edges){
            adj.computeIfAbsent(a){mutableListOf()}.add(b)
            adj.computeIfAbsent(b){mutableListOf()}.add(a)
        }

        val visited = mutableSetOf<Int>()
        var res = 0

        fun getConnectedComponent(i: Int): Set<Int> {
            val queue: Queue<Int> = LinkedList()
            queue.add(i)
            val component = mutableSetOf(i)

            while(queue.isNotEmpty()){
                val node = queue.poll()
                for (neighbor in adj[node] ?: emptyList()){
                    if (neighbor in component){
                        continue
                    }
                    queue.add(neighbor)
                    component.add(neighbor)
                    visited.add(neighbor)
                }
            }
            return component
        }

        fun longestPath(i: Int ): Int {
            val queue: Queue<Pair<Int,Int>> = LinkedList()
            queue.add(i to 1)

            val dist = mutableMapOf(i to 1)

            while(queue.isNotEmpty()){
                val (node, length) = queue.poll()
                for (neighbor in adj[node] ?: emptyList()){
                    if (neighbor in dist){
                        if (dist[neighbor]!! == length){
                            return -1
                        } 
                        continue
                    }
                    queue.add(Pair(neighbor, length + 1))
                    dist[neighbor] = length + 1
                }
            }
             var max = Int.MIN_VALUE
                for (value in dist.values){
                    max = maxOf(max, value)
                }
                return max
        }

        for (i in 1 until n + 1){
            if (i in visited) continue

            visited.add(i)

            val component = getConnectedComponent(i)

            var maxCount = 0

            for (source in component){
                val length = longestPath(source)

                if (length == -1){
                    return -1
                }

                maxCount = maxOf(maxCount, length)
            }
            res += maxCount

        }
        return res
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=Gn0ADjje8Rg

```