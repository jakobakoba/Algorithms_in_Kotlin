## 332. Reconstruct Itinerary


```
class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val adj = mutableMapOf<String, PriorityQueue<String>>()

        for (ticket in tickets){
            adj.computeIfAbsent(ticket[0]){PriorityQueue()}.add(ticket[1])
        }
        
        val itinerary = mutableListOf<String>()
        fun dfs(airport: String){
            while(adj[airport]?.isNotEmpty() == true){
                dfs(adj[airport]!!.poll())
            }
            itinerary.add(0, airport)
        }

        dfs("JFK")
        return itinerary
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```
используется Эйлеров путь, надо почитать

```

