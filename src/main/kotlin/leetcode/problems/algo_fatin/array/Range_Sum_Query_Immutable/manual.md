## 303. Range Sum Query - Immutable


```
class NumArray(nums: IntArray) {
    val prefix = IntArray(nums.size + 1) {0}

    init {
         for (i in 0 until nums.size){
        prefix[i + 1] = prefix[i] + nums[i]
    }
    }
    
   
    fun sumRange(left: Int, right: Int): Int{
        return prefix[right + 1] - prefix[left]
    }
}

```

**Оценка по времени**: 
Initialization O(n)
sumRange O(1)


**Оценка по памяти**: О(n)


**Описание решения**
```

```