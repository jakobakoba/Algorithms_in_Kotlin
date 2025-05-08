## 1920. Build Array from Permutation


```
class Solution {
    fun buildArray(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n)

        for (i in 0 until n){
            ans[i] = nums[nums[i]]
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

