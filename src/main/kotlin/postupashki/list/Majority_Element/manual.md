## 169. Majority Element


map but this solution is not passing constraints for follow up
```
class Solution {
    fun majorityElement(nums: IntArray): Int {
        val n = nums.size
        val mid = n / 2

        val map = mutableMapOf<Int, Int>()
        for (num in nums){
            map[num] = map.getOrDefault(num, 0)+ 1
            if (map[num]!! > mid){
                return num
            }
        }
        throw IllegalStateException(" ")
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
очень коварная ловушка должно быть > mid, а не >= mid.


```

follow up time O(n) and space O(1) Boyer Moore
```
class Solution {
    fun majorityElement(nums: IntArray): Int {
        var count = 1
        var num = nums[0]

        for (i in 1 until nums.size){
            if (nums[i] == num){
                count += 1
            } else {
                if (count == 0){
                    num = nums[i]
                    count = 1
                } else {
                    count -= 1
                }
            }
        }
        return num
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

