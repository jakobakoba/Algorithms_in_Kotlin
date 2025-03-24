## 1976. Number of Ways to Arrive at Destination


```
class Solution {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val adj = mutableMapOf<Int,Int>()
        for ((a,b,c) in roads){
            adj.computeIfAbsent(a){mutableListOf()}.add(Pair(c, b))
            adj.computeIfAbsent(b){mutableListOf()}.add(Pair(c, a))
        }
        val MOD = 1_000_000_007
        
        val pq = PriorityQueue(compareBy<Pair<Int,Int>>{it.first})
        pq.add(Pair(0,0)
        
        val minCost = IntArray(n){Int.MAX_VALUE}
        val pathCount = IntArray(n)
        pathCout[0] = 1
        
        while(pq.isNotEmpty()){
            val (cost, node) = pq.poll()
            
            if (cost > minCost[node]) continue
            
            adj[node]?.forEach{(neiCost, nei) ->
            val newCost = cost + neiCost
            if (newCost < minCost[nei]){
                minCost[nei] = newCost
                pathCount[nei] = pathCount[node]
                pq.add(Pair(newCost, nei))
            } else if (newCost == minCost[nei]){
                pathCount[nei] = (pathCount[nei] + pathCount[node]) % MOD
            }
        }
        return  pathCount[n-1]
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```