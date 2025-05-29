## 724. Find Pivot Index

prefix
```

class Solution {
    fun pivotIndex(nums: IntArray): Int {
        
        var count = 0

        val n = nums.size
        val sum = nums.sum()

        val arr = IntArray(n + 1)

        for (i in 0 until n){
            arr[i + 1] = arr[i] + nums[i]
        }

        for (i in 0 until n){
            if (arr[i] == arr[n] - arr[i + 1]){
                return i
            }
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