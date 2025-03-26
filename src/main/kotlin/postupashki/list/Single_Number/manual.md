## 136. Single Number


```
class Solution {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        for (num in nums){
            ans = ans xor num
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

не соответствует constraints, but still:
```
class Solution {
    fun singleNumber(nums: IntArray): Int {
        nums.sort()

        var counter = 1
        var prev = nums[0]

        for (i in 1 until nums.size){
            if (nums[i] == prev){
                counter++
            } else {
                if (counter == 1){
                    return prev
                }
                prev = nums[i]
                counter = 1
            }
        }
        return prev
        
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```


