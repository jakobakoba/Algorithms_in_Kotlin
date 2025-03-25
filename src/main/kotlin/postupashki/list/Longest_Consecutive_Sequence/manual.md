## 128. Longest Consecutive Sequence


```
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums){
            set.add(num)
        }
        var total = 0

        for (num in nums){
            if (num - 1 !in set){
                var temp = 0
                var counter = num
                while(counter in set){
                    temp++
                    counter++
                }
                total = maxOf(total, temp)
            }
        }
        return total
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```