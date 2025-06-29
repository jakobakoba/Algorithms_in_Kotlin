## 560. Subarray Sum Equals K

```
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val n = nums.size
        val map = mutableMapOf<Int,Int>()
        map[0] = 1

        var count = 0
        var prefix = 0

        for (num in nums){
            prefix += num
            val needed = prefix - k
            if (needed in map){
                count += map[needed]!!
            }
            map[prefix] = map.getOrDefault(prefix, 0 ) + 1
        }
        return count
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
Если temp - k есть в map → значит, раньше была сумма prefix[j] = temp - k → и
 между j и i есть подмассив с суммой k.

Если temp - k был в map 3 раза → значит, есть 3 разных j, от которых 
можно провести подмассив до i с суммой k.

Алгоритм автоматически учитывает только непрерывные подмассивы, потому что:
temp — сумма от 0 до i.
temp - k ищет ровно те j, после которых сумма до i даёт k.
map[temp - k] — это количество валидных j, каждый из которых даёт 
уникальный непрерывный подмассив.
```