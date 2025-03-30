## 3191. Minimum Operations to Make Binary Array Elements Equal to One I


```
class Solution {
    fun minOperations(nums: IntArray): Int {
        fun flip(index: Int){
            if (nums[index] == 0){
                nums[index] = 1
            }  else {
                nums[index] = 0
            }
        }
        var n = nums.size
        var ans = 0
        for (i in 0 until n - 2){
            if (nums[i] == 0){
                flip(i)
                flip(i + 1)
                flip(i + 2)
                ans += 1
            }
        }
        if (nums[n-1] == 0 || nums[n-2] == 0){
            return -1
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```