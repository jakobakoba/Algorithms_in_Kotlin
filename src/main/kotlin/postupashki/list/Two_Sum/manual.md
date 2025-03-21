## 1. Two Sum


```
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int,Int>()

        for (i in 0 until nums.size){
            val needed = target - nums[i]
            if (needed in map){
                return intArrayOf(map[needed]!!, i)
            }
            map[nums[i]] = i
        }
        throw IllegalStateException("")
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```