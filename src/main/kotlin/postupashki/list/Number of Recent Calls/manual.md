## Number of Recent Calls

```
class RecentCounter() {

    val queue: Queue<Int> = LinkedList()

    fun ping(t: Int): Int {
        queue.add(t)
        while(queue.isNotEmpty() && queue.peek() < t - 3000){
            queue.poll()
        }    
        return queue.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

