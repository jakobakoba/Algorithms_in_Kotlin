## 146. LRU Cache


```
class Node(val key: Int, val `val`: Int){
    var prev: Node? = null
    var next: Node? = null
}

class LRUCache(val capacity: Int) {

    val cache = mutableMapOf<Int,Node>()

    var left = Node(0,0)
    var right = Node(0,0)

    init {
        left.next = right
        right.prev = left
    }

    fun remove(node: Node){
        val (prev, next) = listOf(node.prev!!, node.next!!)
        prev.next = next
        next.prev = prev
    }

    fun insert(node: Node){
        val (prev, next) = listOf(right.prev!!, right!!)
        prev.next = node
        next.prev = node
        node.prev = prev
        node.next = next
    }

    fun get(key: Int): Int {
        if (key in cache){
            remove(cache[key]!!)
            insert(cache[key]!!)
            return cache[key]!!.`val`
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (key in cache){
            remove(cache[key]!!)
        }
        cache[key] = Node(key, value)

        insert(cache[key]!!)

        if (cache.size > capacity){
            val lru = left.next!!
            remove(lru)
            cache.remove(lru.key)
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

```

**Оценка по времени**: О(1)


**Оценка по памяти**: О(capacity)


**Описание решения**
```
neetcode:
https://www.youtube.com/watch?v=7ABFKPK2hD4

```

