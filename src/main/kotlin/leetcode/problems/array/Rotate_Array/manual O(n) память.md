## 189. Rotate Array


```
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val new = IntArray(nums.size)

        for (i in 0 until nums.size){
            val newIndex = (i + k) % nums.size
            new[newIndex] = nums[i]
        }
        for (i in 0 until nums.size){
            nums[i] = new[i]
        }
        
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```