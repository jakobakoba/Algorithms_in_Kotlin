## 27. Remove Element


```
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var pointer = 0
        for (i in 0 until nums.size){
            if (nums[i] != `val`){
                nums[pointer] = nums[i]
                pointer++
            }
        }
        return pointer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

