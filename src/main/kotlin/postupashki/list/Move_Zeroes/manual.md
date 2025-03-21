## 283. Move Zeroes


```
class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var pointer = 0

        for (i in 0 until nums.size){
            if (nums[i] != 0){
                nums[pointer] = nums[i].also{nums[i] = nums[pointer]}
                pointer++
            }
        }
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```