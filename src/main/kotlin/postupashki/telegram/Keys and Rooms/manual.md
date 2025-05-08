## 841. Keys and Rooms

BFS
```
class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n = rooms.size
        val opened = BooleanArray(n)
        opened[0] = true

        val queue:Queue<Int> = LinkedList()

        for (room in rooms[0]){
            queue.add(room)
        }

        while(queue.isNotEmpty()){
            val room = queue.poll()
            if (opened[room] == true) continue

            for (x in rooms[room]){
                queue.add(x)
            }
            opened[room] = true
        }

        return opened.all{it == true}
    }
}

```

**Оценка по времени**: О(N + E)


**Оценка по памяти**: О(N)


**Описание решения**
```

```

DFS
```
class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        
        fun dfs(room: Int){
            if (visited[room]) return
            
            visited[room] = true
            for (r in rooms[room]){
                dfs(r)
            }
        }
        dfs(0)
        return visited.all{it == true}
    }
}


```

**Оценка по времени**: О(N + E)


**Оценка по памяти**: О(N)


**Описание решения**
```

```

