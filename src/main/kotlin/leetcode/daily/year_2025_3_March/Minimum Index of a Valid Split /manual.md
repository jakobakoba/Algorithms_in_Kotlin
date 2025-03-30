## 2780. Minimum Index of a Valid Split


```
class Solution {
    fun minimumIndex(nums: List<Int>): Int {
        var count = 1
        var num = nums[0]
        val n = nums.size

        for (i in 1 until n){
            if (nums[i] == num){
                count++
            } else {
                if (count == 0){
                    num = nums[i]
                    count = 1
                } else {
                    count--
                }
            }
        }
        
        var amount = nums.count{it == num}
        var counter = 0

        for (i in 0 until n){
            if (nums[i] == num){
                counter++
            }
            val isLeftDominant = counter * 2 > i + 1
            val isRightDominant = (amount - counter) * 2 > n - (i + 1)
            if (isLeftDominant && isRightDominant){
                return i
            }
        }
        return -1
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```