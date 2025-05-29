## 523. Continuous Subarray Sum


```
class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int,Int>()
        map[0] = -1

        var temp = 0

        for (i in 0 until nums.size){
            temp += nums[i]
            temp = temp % k
            if (temp !in map){
                map[temp] = i
            } else {
                if (i - map[temp]!! >= 2){
                    return true
                }
            }
        }
        return false
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(min(n, k))


**Описание решения**
```
https://www.youtube.com/watch?v=OKcrLfR-8mE

map[0] = -1
Как это работает?
    Когда мы встречаем остаток 0 у какого-то индекса i, значит сумма элементов от индекса после того, где остаток был 0 в первый раз и до i делится на k.
    Первый раз остаток 0 у нас был в -1 (до начала массива).
    Значит, сумма от 0 до i делится на k.
Пример
    map[0] = -1
    На i = 4 остаток 0 — значит сумма от индекса 0 до 4 делится на k.
    Длина подмассива = 4 - (-1) = 5 — всё правильно.

```