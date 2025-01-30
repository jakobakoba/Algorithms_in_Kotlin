## 724. Find Pivot Index


```

class Solution {
    fun pivotIndex (nums: IntArray): Int {
        val n =  nums.size
        
        val prefix = IntArray(n + 1){0}
        
        for (i in 0 until n){
            prefix[i + 1] = prefix[i] + nums[i]
        }
        
        val postfix = IntArray(n + 1){0}
        
        for (i in n - 1 downTo 0){
            postfix[i] = postfix[i + 1] + nums[i]
        
        }
        for (i in 0 until n){
            if (postfix[i + 1] == prefix[i]) return i
        }
        return -1
    }
}
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```