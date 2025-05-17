## 146. LRU Cache


```
class LRUCache(val capacity: Int) {

    class Node(
        val key: Int,
        val value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    val left = Node(0,0)
    val right = Node(0,0)

    init {
        left.next = right
        right.prev = left
    }

    val cache = mutableMapOf<Int,Node>()

    fun remove(node: Node){
        val prev = node.prev!!
        val next = node.next!!

        prev.next = next
        next.prev = prev
    }

    fun insert(node: Node){
        val left = right.prev!!
        val right = right!!

        node.next = right
        node.prev = left
        left.next = node
        right.prev = node
    }


    fun get(key: Int): Int {
        if (key in cache){
            val node = cache[key]!!
            remove(node)
            insert(node)
            return node.value
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

