## 380. Insert Delete GetRandom O(1)


```
class RandomizedSet() {
    val list = mutableListOf<Int>()
    val map = mutableMapOf<Int,Int>()

    fun insert(`val`: Int): Boolean {
        val res = `val` !in map
        if (res){
            map[`val`] = list.size
            list.add(`val`)
        }
        return res
    }

    fun remove(`val`: Int): Boolean {
        val res = `val` in map
        if (res){
            val index = map[`val`]!!
            val last = list.last()
            list[index] = last
            list.removeLast()
            map[last] = index
            map.remove(`val`)
        }
        return res
    }

    fun getRandom(): Int {
        return list[Random.nextInt(list.size)]
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */

```

**Оценка по времени**: О(1)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

