## 3243. Shortest Distance After Road Addition Queries I


```

class Solution{
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
       
       val adj = Array(n) {mutableListOf<Int>()}
       
       for (i in 0 until n - 1){
        adj[i].add(i + 1)
       }
       
       fun bfs(): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        
        queue.offer(Pair(0,0))
        
        val visited = mutableListOf<Int>()
        
        while(queue.isNotEmpty()){
            val (node, length) = queue.poll()
            
            if (node == n - 1){
                return length
            } else {
                for (neighbor in adj[node]){
                    if (neighbor !in visited){
                        queue.offer(Pair(neighbor, length + 1))
                        visited.add(neighbor)
                    }
                }
            }
        }
        throw IllegalStateException(" ")
       }
       
       
       val answer = mutableListOf<Int>()
       for (query in queries){
        adj[query[0]].add(query[1])
        answer.add(bfs())
       }
       return answer.toIntArray()
       
    }
}




```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
neetcode
создать adjacency list где для каждого шага сохраняем все 
возможные шаги

adj[src].append(dst)
и потом запускаем bfs

bfs: в queue добавляем (node = 0, length = 0)

while queue.isNotEmpty() делаем poll
если мы дошли до n-1, возвращаем length
если мы еще не дошли то добавляем в queue соседей (следующие
шаги) с добавлением + 1
тут важный момент, что мы не хотим добавлять один 
и тот же шаг несколько раз и поймать бесконечный цикл
поэтому создаем set и проверку которая говорит добавляю 
только если этот шаг не был сделан
```