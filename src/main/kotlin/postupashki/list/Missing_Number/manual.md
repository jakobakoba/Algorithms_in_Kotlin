## 268. Missing Number


```
class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        var size = 0
        for (i in 0 until nums.size){
            sum += nums[i]
            size++
        }
        return (size * (size + 1) / 2) - sum
    }
}

solution 2:
class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        val target = n * (n + 1) / 2
        val sum = nums.sum()
        return target - sum
    }
}
```



**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```